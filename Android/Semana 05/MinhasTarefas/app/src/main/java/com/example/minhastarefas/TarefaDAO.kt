package com.example.minhastarefas

import android.content.ContentValues
import android.content.Context

class TarefaDAO {
    private val banco: BancoHelper

    constructor(context: Context){
        this.banco = BancoHelper(context)
    }

    fun insert(tarefa: Tarefa){
        val cv = ContentValues()
        cv.put("descricao", tarefa.descricao)
        cv.put("prioridade", tarefa.prioridade)
        cv.put("status", tarefa.status)
        this.banco.writableDatabase.insert("tarefas", null, cv)
    }

    fun count(): Int{
        val colunas = arrayOf("id")
        val c = this.banco.readableDatabase.query("tarefas", colunas, null, null, null, null, null)
        return c.count
    }

    fun find(id: Int):Tarefa?{
        val colunas = arrayOf("id", "descricao", "prioridade", "status")
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        val c = this.banco.readableDatabase.query("tarefas", colunas, where, pWhere, null, null, null, null)
        if (c.count == 1){
            c.moveToFirst()
            val id = c.getInt(c.getColumnIndex("id"))
            val descricao = c.getString(c.getColumnIndex("descricao"))
            val prioridade = c.getInt(c.getColumnIndex("prioridade"))
            val status = c.getInt(c.getColumnIndex("status"))
            val tarefa = Tarefa(id, descricao, prioridade, status)
            return tarefa
        }
        return null
    }

    fun get(): ArrayList<Tarefa>{
        val lista = ArrayList<Tarefa>()
        val colunas = arrayOf("id", "descricao", "prioridade", "status")
        val c = this.banco.readableDatabase.query("tarefas", colunas, null, null, null, null, null)
        if (c.count > 0){
            c.moveToFirst()
            do{
                val id = c.getInt(c.getColumnIndex("id"))
                val descricao = c.getString(c.getColumnIndex("descricao"))
                val prioridade = c.getInt(c.getColumnIndex("prioridade"))
                val status = c.getInt(c.getColumnIndex("status"))
                val tarefa = Tarefa(id, descricao, prioridade, status)
                lista.add(tarefa)
            }while (c.moveToNext())
        }

        return lista
    }

    fun update(tarefa: Tarefa){
        val cv = ContentValues()
        val where = "id = ?"
        val pWhere = arrayOf(tarefa.id.toString())
        cv.put("descricao", tarefa.descricao)
        cv.put("prioridade", tarefa.prioridade)
        cv.put("status", tarefa.status)
        this.banco.writableDatabase.update("tarefas", cv, where, pWhere)
    }

    fun delete(id: Int){
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        this.banco.writableDatabase.delete("tarefas", where, pWhere)
    }
}
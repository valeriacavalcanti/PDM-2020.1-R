package com.example.minhastarefas

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoHelper (context: Context) :SQLiteOpenHelper(context, "tarefa.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val c1 = "id integer primary key autoincrement, "
        val c2 = "descricao text, "
        val c3 = "prioridade integer, "
        val c4 = "status integer "
        val sql = "create table  tarefas ( ${c1} ${c2} ${c3} ${c4} )"

        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table tarefas")
        this.onCreate(db)
    }

}
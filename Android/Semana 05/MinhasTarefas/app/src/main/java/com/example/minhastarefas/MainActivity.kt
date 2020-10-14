package com.example.minhastarefas

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

val INSERIR = 1
val EDITAR = 2

class MainActivity : AppCompatActivity() {
    private lateinit var lvTarefas: ListView
    private lateinit var btAdd: FloatingActionButton
    private lateinit var dao: TarefaDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.dao = TarefaDAO(this)

        this.lvTarefas = findViewById(R.id.lvMainTarefas)
        this.btAdd = findViewById(R.id.fabMainAdd)

        this.atualiza()

        this.btAdd.setOnClickListener { add(it) }
        this.lvTarefas.onItemClickListener = OnClick()
        this.lvTarefas.onItemLongClickListener = OnLongClick()
    }

    private fun atualiza(){
        this.lvTarefas.adapter = TarefaAdapter(this, this.dao.get())
    }

    private fun add(view: View){
        val intent = Intent(this, FormActivity::class.java)
        startActivityForResult(intent, INSERIR)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK){
            val tarefa = data?.getSerializableExtra("TAREFA") as Tarefa
            if (requestCode == INSERIR){
                this.dao.insert(tarefa)
            }else{
                //EDITAR
                this.dao.update(tarefa)
            }
            this.atualiza()
        }
    }

    inner class OnClick : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val intent = Intent(this@MainActivity, FormActivity::class.java)
            val tarefa = this@MainActivity.dao.find(id.toInt())
            intent.putExtra("TAREFA", tarefa)
            startActivityForResult(intent, EDITAR)
        }
    }

    inner class OnLongClick: AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long
        ): Boolean {
            val tarefa = this@MainActivity.dao.find(id.toInt())
            if (tarefa != null){
                val dialog = AlertDialog.Builder(this@MainActivity)
                dialog.setTitle("Atenção")
                dialog.setMessage("Deseja excluir a tarefa '${tarefa?.descricao}' ?")
                dialog.setPositiveButton("Sim", { dialogInterface: DialogInterface, i: Int ->
                    this@MainActivity.dao.delete(tarefa.id)
                    this@MainActivity.atualiza()
                })
                dialog.setNegativeButton("Não", null)
                dialog.create().show()
            }else{
                Toast.makeText(this@MainActivity, "Tarefa não encontrada.", Toast.LENGTH_SHORT).show()
            }
            return true
        }
    }
}
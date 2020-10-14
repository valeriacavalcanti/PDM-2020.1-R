package com.example.minhastarefas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class FormActivity : AppCompatActivity() {
    private lateinit var etDescricao: EditText
    private lateinit var sbPrioridade: SeekBar
    private lateinit var tvPrioridade: TextView
    private lateinit var rbAberto: RadioButton
    private lateinit var rbExecutando: RadioButton
    private lateinit var rbConcluido: RadioButton
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.etDescricao = findViewById(R.id.etFormDescricao)
        this.sbPrioridade = findViewById(R.id.sbFormPrioridade)
        this.tvPrioridade = findViewById(R.id.tvFormPrioridade)
        this.rbAberto = findViewById(R.id.rbFormAberto)
        this.rbExecutando = findViewById(R.id.rbFormExecutando)
        this.rbConcluido = findViewById(R.id.rbFormConcluido)
        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btCancelar = findViewById(R.id.btFormCancelar)

        this.btSalvar.setOnClickListener { salvar(it) }
        this.btCancelar.setOnClickListener { cancelar(it) }

        this.sbPrioridade.setOnSeekBarChangeListener( OnChange() )

        if (intent.hasExtra("TAREFA")){
            val tarefa = intent.getSerializableExtra("TAREFA") as Tarefa
            this.etDescricao.text.append(tarefa.descricao)
            this.sbPrioridade.progress = tarefa.prioridade
            this.tvPrioridade.text = tarefa.prioridade.toString()
            if (tarefa.status == Tarefa.ABERTO){
                this.rbAberto.isChecked = true
            }else if (tarefa.status == Tarefa.EXECUTANDO){
                this.rbExecutando.isChecked = true
            }else{
                this.rbConcluido.isChecked = true
            }
        }else{
            this.tvPrioridade.text = "1"
            this.rbAberto.isChecked = true
        }
    }

    private fun salvar(view: View){
        val descricao = this.etDescricao.text.toString()
        val prioridade = this.sbPrioridade.progress
        val status = if (this.rbAberto.isChecked) Tarefa.ABERTO
                          else if (this.rbExecutando.isChecked) Tarefa.EXECUTANDO
                          else Tarefa.CONCLUIDO
        val tarefa = Tarefa(descricao, prioridade, status)

        if (intent.hasExtra("TAREFA"))
            tarefa.id = (intent.getSerializableExtra("TAREFA") as Tarefa).id

        val intent = Intent()
        intent.putExtra("TAREFA", tarefa)
        setResult(RESULT_OK, intent)
        finish()
    }

    private fun cancelar(view: View){
        finish()
    }

    inner class OnChange: SeekBar.OnSeekBarChangeListener{
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            this@FormActivity.tvPrioridade.text = progress.toString()
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {
        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {
        }

    }
}
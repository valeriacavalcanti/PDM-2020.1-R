package com.example.minhastarefas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class TarefaAdapter(var context: Context, var lista: ArrayList<Tarefa>): BaseAdapter() {

    override fun getCount(): Int {
        return this.lista.count()
    }

    override fun getItem(position: Int): Any {
        return this.lista.get(position)
    }

    override fun getItemId(position: Int): Long {
        return this.lista.get(position).id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var linha: View

        if (convertView == null){
            val inflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            linha = inflater.inflate(R.layout.tarefa_linha, null)
        }else{
            linha = convertView
        }

        val ivStatus = linha.findViewById<ImageView>(R.id.ivTarefaStatus)
        val tvDescricao = linha.findViewById<TextView>(R.id.tvTarefaDescricao)
        val tvPrioridade = linha.findViewById<TextView>(R.id.tvTarefaPrioridade)

        val tarefa = lista.get(position)

        tvDescricao.text = tarefa.descricao
        tvPrioridade.text = tarefa.prioridade.toString()

        if (tarefa.status == Tarefa.ABERTO)
            ivStatus.setBackgroundResource(R.drawable.ic_baseline_add_circle_outline_24)
        else if (tarefa.status == Tarefa.EXECUTANDO)
            ivStatus.setBackgroundResource(R.drawable.ic_baseline_play_circle_outline_24)
        else
            ivStatus.setBackgroundResource(R.drawable.ic_baseline_check_circle_outline_24)

        linha.minimumHeight = 120
        return linha
    }
}
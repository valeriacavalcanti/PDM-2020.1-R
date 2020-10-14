package com.example.minhastarefas

import java.io.Serializable

class Tarefa : Serializable{
    var id: Int
    var descricao: String
    var prioridade: Int
    var status: Int

    // constantes públicas
    companion object{
        const val ABERTO = 1
        const val EXECUTANDO = 2
        const val CONCLUIDO = 3
    }

    // sem ID
    constructor(descricao: String, prioridade: Int, status: Int){
        this.id = -1
        this.descricao = descricao
        this.prioridade = prioridade
        this.status = status
    }

    // com ID
    constructor(id: Int, descricao: String, prioridade: Int, status: Int){
        this.id = id
        this.descricao = descricao
        this.prioridade = prioridade
        this.status = status
    }

    override fun toString(): String {
        return "${id} ${descricao} ${prioridade} ${status}"
    }
}
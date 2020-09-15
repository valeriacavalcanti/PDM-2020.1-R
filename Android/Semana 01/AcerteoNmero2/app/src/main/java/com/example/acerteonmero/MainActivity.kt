package com.example.acerteonmero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var tvDica1: TextView
    private lateinit var tvDica2: TextView
    private lateinit var tvDica3: TextView
    private lateinit var etChute: EditText
    private lateinit var btChute: Button
    private var numero = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvDica1 = findViewById(R.id.tvDica1)
        this.tvDica2 = findViewById(R.id.tvDica2)
        this.tvDica3 = findViewById(R.id.tvDica3)

        this.etChute = findViewById(R.id.etChute)

        this.btChute = findViewById(R.id.btVerificar)
        this.btChute.setOnClickListener { onClick(it) }

        this.novoJogo()
    }

    private fun novoJogo(){
        this.numero = this.gerarNumero()
        Log.i("APP_ACERTE", this.numero.toString())

        this.tvDica1.text = this.dica1(this.numero)
        this.tvDica2.text = this.dica2(this.numero)
        this.tvDica3.text = this.dica3(this.numero)

        this.etChute.text.clear()
    }

    private fun gerarNumero(): Int{
        return Random.nextInt(1, 101)
    }

    // Dica 1: Divisores entre 1 e 10
    private fun dica1(numero: Int): String{
        var lista = ArrayList<Int>()
        for (i in 1..10){
            if (numero % i == 0)
                lista.add(i)
        }
        return lista.toString()
    }

    // Dica 2: par ou impar
    private fun dica2(numero: Int):String{
        if (numero % 2 == 0) return "Par"
        else return "Impar"
    }

    // Dica 3: Quantidade de Divisores
    private fun dica3(numero: Int): String{
        var qtde = 0

        for (i in 1.. numero/2){
            if (numero % i == 0)
                qtde += 1
        }
        return (qtde + 1).toString()
    }

    // listener
    private fun onClick(view: View){
        var chute = this.etChute.text.toString().toInt()

        if (chute == this.numero)
            Toast.makeText(this, "Acertou!", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "Errou! O número é ${this.numero}", Toast.LENGTH_SHORT).show()

        this.novoJogo()
    }

    override fun onRestart() {
        super.onRestart()

        this.novoJogo()
    }
}
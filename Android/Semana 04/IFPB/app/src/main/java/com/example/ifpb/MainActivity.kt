package com.example.ifpb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btClicar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btClicar = findViewById(R.id.btClicar)
        this.btClicar.setOnClickListener { clicar(it) }
    }

    private fun clicar(view: View){
        val intent = Intent("INSTITUICAO")
        intent.putExtra("URL", "http://www.ifpb.edu.br")
        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else {
            Toast.makeText(this, "Sem aplicativo", Toast.LENGTH_SHORT).show()
        }
    }
}
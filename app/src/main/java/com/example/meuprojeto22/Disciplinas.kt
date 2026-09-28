package com.example.meuprojeto22

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Disciplinas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_disciplinas)

        val disciplinas = listOf(
            R.id.programacao,
            R.id.bancoDados,
            R.id.engenhariaSoftware,
            R.id.desenvolvimentoWeb,
            R.id.desenvolvimentoMobile,
            R.id.inteligenciaArtificial
        )

        for (id in disciplinas) {
            val item = findViewById<TextView>(id)
            item.setOnClickListener {
                val intent = Intent(this, DetalhesDisciplinaActivity::class.java)
                intent.putExtra("disciplina", item.text.toString().removePrefix("• "))
                startActivity(intent)
            }
        }

        val btnVoltar = findViewById<Button>(R.id.btnVoltar)

        btnVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

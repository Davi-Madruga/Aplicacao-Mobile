package com.example.meuprojeto22

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalhesDisciplinaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes_disciplina)

        val nome = intent.getStringExtra("disciplina")
        val dados = when (nome) {
            "Programação" -> listOf(
                "Lógica de programação, variáveis, condições, repetições e funções.",
                "80 horas", "Presencial", "Básico", "Nenhum"
            )
            "Banco de Dados" -> listOf(
                "Modelagem de dados, tabelas, relacionamentos e consultas SQL.",
                "60 horas", "Presencial", "Básico", "Nenhum"
            )
            "Engenharia de Software" -> listOf(
                "Requisitos, planejamento, desenvolvimento e testes de software.",
                "60 horas", "Presencial", "Intermediário", "Programação"
            )
            "Desenvolvimento Web" -> listOf(
                "Criação de páginas e aplicações com HTML, CSS e JavaScript.",
                "80 horas", "Presencial", "Intermediário", "Programação"
            )
            "Desenvolvimento Mobile" -> listOf(
                "Criação de aplicativos Android com Kotlin, telas e navegação.",
                "80 horas", "Presencial", "Intermediário", "Programação"
            )
            "Inteligência Artificial" -> listOf(
                "Introdução ao aprendizado de máquina e suas aplicações.",
                "60 horas", "Presencial", "Avançado", "Programação e Banco de Dados"
            )
            else -> {
                finish()
                return
            }
        }

        findViewById<TextView>(R.id.nomeDisciplina).text = nome
        findViewById<TextView>(R.id.descricaoDisciplina).text = "Descrição: ${dados[0]}"
        findViewById<TextView>(R.id.cargaHoraria).text = "Carga horária: ${dados[1]}"
        findViewById<TextView>(R.id.modalidade).text = "Modalidade: ${dados[2]}"
        findViewById<TextView>(R.id.nivel).text = "Nível: ${dados[3]}"
        findViewById<TextView>(R.id.preRequisito).text = "Pré-requisito: ${dados[4]}"
        findViewById<Button>(R.id.btnVoltar).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.btnCompartilhar).setOnClickListener {
            val texto = """
                $nome
                Descrição: ${dados[0]}
                Carga horária: ${dados[1]}
                Modalidade: ${dados[2]}
                Nível: ${dados[3]}
                Pré-requisito: ${dados[4]}
            """.trimIndent()
            val compartilhar = Intent(Intent.ACTION_SEND)
            compartilhar.type = "text/plain"
            compartilhar.putExtra(Intent.EXTRA_TEXT, texto)
            startActivity(Intent.createChooser(compartilhar, "Compartilhar disciplina"))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

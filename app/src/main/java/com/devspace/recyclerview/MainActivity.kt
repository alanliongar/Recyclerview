package com.devspace.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //
        //criação dataclass - ícone, nome e telefone - é uma classe
        //criação da lista - vários objetos da classe
        //criar um adapter
        //set adapter
        //LinearLayout manager
        val rvList = findViewById<RecyclerView>(R.id.rv_list)


    }
}

val contacts = listOf(
    Contact("Alan", "1194327532874", R.drawable.gato),
    Contact("Gatin", "1194327532874", R.drawable.gato),
    Contact("Cachorro", "1194327532874", R.drawable.gato),
    Contact("Macaco", "1194327532874", R.drawable.gato),
    Contact("Alan", "1194327532874", R.drawable.gato),
    Contact("Gatin", "1194327532874", R.drawable.gato),
    Contact("Cachorro", "1194327532874", R.drawable.gato),
    Contact("Macaco", "1194327532874", R.drawable.gato),
    Contact("Alan", "1194327532874", R.drawable.gato),
    Contact("Gatin", "1194327532874", R.drawable.gato),
    Contact("Cachorro", "1194327532874", R.drawable.gato),
    Contact("Macaco", "1194327532874", R.drawable.gato),
    Contact("Alan", "1194327532874", R.drawable.gato),
    Contact("Gatin", "1194327532874", R.drawable.gato),
    Contact("Cachorro", "1194327532874", R.drawable.gato),
    Contact("Macaco", "1194327532874", R.drawable.gato),
    Contact("Alan", "1194327532874", R.drawable.gato),
    Contact("Gatin", "1194327532874", R.drawable.gato),
    Contact("Cachorro", "1194327532874", R.drawable.gato),
    Contact("Macaco", "1194327532874", R.drawable.gato)
)
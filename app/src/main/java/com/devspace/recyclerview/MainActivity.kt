package com.devspace.recyclerview

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
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
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }

        ivGrid.setOnClickListener{
            rvList.layoutManager = GridLayoutManager(this,2)
        }
    }
}

private val contacts = listOf(
    Contact("Ale", "(+55) 11 91234-5678", R.drawable.ale),
    Contact("Bach", "(+55) 11 91234-5678", R.drawable.bach),
    Contact("Caian Corporativo", "(+55) 11 91234-5678", R.drawable.caian1),
    Contact("Caian Pessoal", "(+55) 11 91234-5678", R.drawable.caian2),
    Contact("Ximbinha", "(+55) 11 91234-5678", R.drawable.chimbinha),
    Contact("Sr Defumado", "(+55) 11 91234-5678", R.drawable.furtado),
    Contact("Goku", "(+55) 11 91234-5678", R.drawable.goku),
    Contact("Lalau Machiavelli", "(+55) 11 91234-5678", R.drawable.lalau),
    Contact("Miguel Jefferson", "(+55) 11 91234-5678", R.drawable.miguel),
    Contact("Muniz", "(+55) 11 91234-5678", R.drawable.muniz),
    Contact("Mussum", "(+55) 11 91234-5678", R.drawable.mussum),
    Contact("Pericles", "(+55) 11 91234-5678", R.drawable.pericles),
    Contact("Urecubaba", "(+55) 11 91234-5678", R.drawable.rockbama),
    Contact("Silvao", "(+55) 11 91234-5678", R.drawable.silvao),
    Contact("Gatinho", "(+55) 11 91234-5678", R.drawable.gato)
)
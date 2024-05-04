package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContactDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val icon = intent.getIntExtra("image", R.drawable.caian1)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_phone = findViewById<TextView>(R.id.tv_phone)
        val image = findViewById<ImageView>(R.id.image)
        val tv_share = findViewById<TextView>(R.id.tv_share_contact)

        tv_name.text = name
        tv_phone.text = phone
        image.setImageResource(icon)

        tv_share.setOnClickListener {
            println("Ricardinho")
            //Intent implícita: não sabemos PRA ONDE vamos mandar
            val sendIntent: Intent = Intent().apply{
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "$name $phone")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}
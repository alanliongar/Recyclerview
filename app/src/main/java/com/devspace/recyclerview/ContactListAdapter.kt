package com.devspace.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ContactListAdapter: ListAdapter<Contact, ContactViewHolder>(ContactDiffUtils()) {

    private lateinit var onClickListener: (Contact) -> Unit

    public fun setOnClickListener(onClick: (Contact) -> Unit) {
        onClickListener = onClick //aqui ele inicializa a variável do tipo função void
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder { //Função que devolve a classe, recebe um viewgroup e int como parametros.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)//lembrar que essa função é chamada automaticamente.
        return ContactViewHolder(view)
    }
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact, onClickListener)
    }
    //compara a diferença quando nossa lista é atualizada
}

class ContactDiffUtils() : DiffUtil.ItemCallback<Contact>() { //isso aqui serve para comparar a diferença entre as listas, rever pra que isso serve dps.
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return (oldItem == newItem)
    }
    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return (oldItem.name == newItem.name)
    }
}

class ContactViewHolder(private val view: View) : RecyclerView.ViewHolder(view) { //essa view aqui, é o item layout inflado
    private val tvName = view.findViewById<TextView>(R.id.tv_name)
    private val tvPhone = view.findViewById<TextView>(R.id.tv_phone)
    private val image = view.findViewById<ImageView>(R.id.image)
    fun bind(contact: Contact, onClick: (Contact) -> Unit) {
        tvName.text = contact.name
        tvPhone.text = contact.phone
        image.setImageResource(contact.icon)
        view.setOnClickListener {
            onClick.invoke(contact)
        }
    }
}
//nao
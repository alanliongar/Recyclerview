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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val ref_item = R.layout.item_list
        val view = inflater.inflate(ref_item, parent, false)//lembrar que essa função é chamada automaticamente.
        return ContactViewHolder(view)
        //essa função é chamada automaticamente, ela infla o ítem, e devolve a view inflada (xml compilado)
        //em resumo: ela serve pra 'compilar na mão' um XML, não preciso me preocupar em chamar ela pq a chamada é automática, só preciso
        //me preocupar em entregar os parametros certos pra ela, e isso eu faço quando extender a função.
    }
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact, onClickListener)
        /*
        * essa função serve simplesmente para DAR AS INFORMAÇÕES EM TEMPO REAL para que a view (da função anterior)
        * tenha informações dentro dela. Ou seja: como a anterior inflou o item_list, agora cada um dos componentes do UI
        * do item_list precisam ter o seu dado específico. Aí é hora de chamar a função que entrega o valor do vetor
        * para o componente de ui (em cada um dos casos)
        * */
    }
}


//ambas as funções acima funcionam JUNTAS, por isso elas precisam ser declaradas e usadas juntas. Cada item do item_list
//está associado por que pra cada ítem da lista, é tratado em cada chamada das duas funções (juntas), por isso funcionam
//a de cima infla o item específico, e devolve o objeto daquele item_list, a de baixo pega o mesmo objeto (magias do java)
//e associa à view inflada, os dados da lista de objetos (Contatos).




/*É importante entender a função de cada coisa aqui: O oncreateviewholder é a função que vai INFLAR o layout que contem um ítem do rv
* e vai devolver a referencia da view (retornar ela), já inflada.
* E por sua vez, o onbindviewholder, vai atrelar cada dado do vetor, a um componente de ui do item.
* */

class ContactViewHolder(private val view: View) : RecyclerView.ViewHolder(view) { //essa view aqui, é o item layout inflado
    private val tvName = view.findViewById<TextView>(R.id.tv_name)
    private val tvPhone = view.findViewById<TextView>(R.id.tv_phone)
    private val image = view.findViewById<ImageView>(R.id.image)
    fun bind(contact: Contact, onClick: (Contact) -> Unit) {
        tvName.text = contact.name
        tvPhone.text = contact.phone
        image.setImageResource(contact.icon)
        view.setOnClickListener {//ação do butão
            onClick.invoke(contact)
        }
    }
}

class ContactDiffUtils() : DiffUtil.ItemCallback<Contact>() { //isso aqui serve para comparar a diferença entre as listas, rever pra que isso serve dps.
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return (oldItem == newItem)
    }
    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return (oldItem.name == newItem.name)
    }
}

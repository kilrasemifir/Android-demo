package aston.semifir.demo.android

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UtilisateurAdapter(val dataSet: ArrayList<Utilisateur>, val context: Context):
    RecyclerView.Adapter<UtilisateurAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textNom: TextView
        val textPrenom: TextView
        val deleteButton: ImageView
        val editButton: ImageView
        init {
            textNom = view.findViewById(R.id.text_nom)
            textPrenom = view.findViewById(R.id.text_prenom)
            deleteButton = view.findViewById(R.id.delete_button)
            editButton = view.findViewById(R.id.edit_button)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textNom.text = dataSet[position].nom
        holder.textPrenom.text = dataSet[position].prenom
        holder.deleteButton.setOnClickListener { onDelete(position) }
        holder.editButton.setOnClickListener { onEdit(position) }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun onDelete(position: Int){
        dataSet.removeAt(position)
        notifyDataSetChanged()
    }

    fun onEdit(position: Int){
        val intent = Intent(this.context, EditActivity::class.java)
        intent.putExtra("position", position)
        context.startActivity(intent)
    }
}
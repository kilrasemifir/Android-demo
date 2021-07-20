package aston.semifir.demo.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class EditActivity : AppCompatActivity() {
    var position: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        position = intent.getIntExtra("position", -1)
        if (position != -1){
            val utilisateur = ListActivity.utilisateurs[position]
            findViewById<EditText>(R.id.edit_user_nom).setText(utilisateur.nom)
            findViewById<EditText>(R.id.edit_user_prenom).setText(utilisateur.prenom)
        }
    }

    fun onClick(view: View){
        val nom = findViewById<EditText>(R.id.edit_user_nom).text.toString()
        val prenom = findViewById<EditText>(R.id.edit_user_prenom).text.toString()
        if (position==-1){
            val utilisateur = Utilisateur(nom, prenom)
            ListActivity.utilisateurs.add(utilisateur)
        } else {
            ListActivity.utilisateurs[position].nom = nom
            ListActivity.utilisateurs[position].prenom = prenom
        }
        finish()
    }
}
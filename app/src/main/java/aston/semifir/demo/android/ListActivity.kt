package aston.semifir.demo.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListActivity : AppCompatActivity() {
    var count = 0
    companion object {
        var utilisateurs = arrayListOf<Utilisateur>(
            Utilisateur("toto", "truc"),
            Utilisateur("toto", "machin")
        )
    }

    val adapter = UtilisateurAdapter(utilisateurs, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste)
        val recyclerView = findViewById<RecyclerView>(R.id.utilisateurListe)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        println("Activity 1: onCreate")
    }

    fun versActivity2(view: View){
        val intent = Intent(this, EditActivity::class.java)
        intent.putExtra("message", "Bonjour de l'activité 1")
        startActivity(intent)
    }

    override fun onRestart() {
        super.onRestart()
        println("Activity 1: OnRestart")
    }

    override fun onStop() {
        super.onStop()
        println("Activity 1: OnStop")
    }

    override fun onResume() {
        super.onResume()
        println("Activity 1: OnResume")
        adapter.notifyDataSetChanged()
    }
}
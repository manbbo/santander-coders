package br.com.digitalhouse.santanderproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var tag: String = "Main"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(maintoolbar)

        play.setOnClickListener{
            startActivity(Intent(this, GameActivity().javaClass))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemView = item.itemId

        when (itemView){
            R.id.home -> Toast.makeText(this, "ADICIONANDO", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }
}
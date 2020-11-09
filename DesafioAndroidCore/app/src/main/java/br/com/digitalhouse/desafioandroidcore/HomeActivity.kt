package br.com.digitalhouse.desafioandroidcore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.digitalhouse.desafioandroidcore.adapters.FoodCardAdapter
import br.com.digitalhouse.desafioandroidcore.data.FoodCardInfo
import kotlinx.android.synthetic.main.activity_home.*
import kotlin.system.exitProcess

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        val cardapio = arrayListOf<FoodCardInfo>(
            FoodCardInfo("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "Fecha às 22:00", R.drawable.image1),
            FoodCardInfo("Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema", "Fecha às 00:00", R.drawable.image4),
            FoodCardInfo("Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo", "Fecha às 00:00", R.drawable.image6),
            FoodCardInfo("Sí Señor!", "Alameda Jauaperi, 626 - Moema", "Fecha às 01:00", R.drawable.image3)
        )

        rc_view.adapter = FoodCardAdapter(cardapio)
        rc_view.layoutManager = LinearLayoutManager(this)
        rc_view.setHasFixedSize(true)
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}
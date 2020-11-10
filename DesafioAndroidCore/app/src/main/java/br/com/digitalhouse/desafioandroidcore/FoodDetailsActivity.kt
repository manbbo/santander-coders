package br.com.digitalhouse.desafioandroidcore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.digitalhouse.desafioandroidcore.adapters.FoodDetailedAdapter
import br.com.digitalhouse.desafioandroidcore.data.FoodCardInfo
import kotlinx.android.synthetic.main.activity_food_details.*
import kotlinx.android.synthetic.main.activity_home.*

class FoodDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)

        bt_back.setOnClickListener {
            finish()
        }

        val cardapio = arrayListOf<FoodCardInfo>(
                FoodCardInfo("Salada com molho de Gengibre", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "Fecha às 22:00", R.drawable.image4),
                FoodCardInfo("Salada com molho de Gengibre", "Alameda dos Arapanés, 532 - Moema", "Fecha às 00:00", R.drawable.image4),
                FoodCardInfo("Salada com molho de Gengibre", "Av. Moaci, 187, 187 - Moema, São Paulo", "Fecha às 00:00", R.drawable.image4),
                FoodCardInfo("Salada com molho de Gengibre", "Alameda Jauaperi, 626 - Moema", "Fecha às 01:00", R.drawable.image4),
                FoodCardInfo("Salada com molho de Gengibre", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "Fecha às 22:00", R.drawable.image4),
                FoodCardInfo("Salada com molho de Gengibre", "Alameda dos Arapanés, 532 - Moema", "Fecha às 00:00", R.drawable.image4),
                FoodCardInfo("Salada com molho de Gengibre", "Av. Moaci, 187, 187 - Moema, São Paulo", "Fecha às 00:00", R.drawable.image4),
                FoodCardInfo("Salada com molho de Gengibre", "Alameda Jauaperi, 626 - Moema", "Fecha às 01:00", R.drawable.image4),
                FoodCardInfo("Salada com molho de Gengibre", "Av. Moaci, 187, 187 - Moema, São Paulo", "Fecha às 00:00", R.drawable.image4),
                FoodCardInfo("Salada com molho de Gengibre", "Alameda Jauaperi, 626 - Moema", "Fecha às 01:00", R.drawable.image4)
        )

        rc_view_twocolumn.adapter = FoodDetailedAdapter(cardapio)
        rc_view_twocolumn.layoutManager = GridLayoutManager(this, 2)
    }
}
package com.example.snackbar.fragments.spending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.snackbar.R
import com.example.snackbar.domain.Gastos
import kotlinx.android.synthetic.main.fragment_detail_gastos.*
import kotlinx.android.synthetic.main.fragment_detail_gastos.view.*

class DetailGastosFragment : AppCompatActivity() {
    private var listGastos = getListGastos()

    fun getListGastos() : ArrayList<Gastos> {
        var arrayGastos = ArrayList<Gastos>()

        for (i:Int in 0 until intent.getStringArrayListExtra("descricao")!!.size) {
            arrayGastos.add(Gastos(intent.getStringArrayListExtra("descricao")!![i],
                    intent.getStringArrayListExtra("categoria")!![i],
                    intent.getStringArrayListExtra("datahora")!![i],
                    intent.getStringArrayListExtra("valor")!![i]))
        }

        return arrayGastos
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_detail_gastos)

        rcGastos.adapter = DetailsGastosAdapter(listGastos)
        rcGastos.layoutManager = LinearLayoutManager(this)
        rcGastos.setHasFixedSize(true)
    }

}
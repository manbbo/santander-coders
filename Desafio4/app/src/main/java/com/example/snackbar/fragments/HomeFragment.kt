package com.example.snackbar.fragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.provider.CalendarContract
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import com.example.snackbar.R
import kotlinx.android.synthetic.main.cards_layout.*


class HomeFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_home, container, false)

        //var bt_Sem = R.id.sem
        //var bt_Mes = R.id.mes
        //var bt_Ano = R.id.ano

        //var l_card = R.id.card
        //var l_card_title = R.id.card_title
        //var l_card_value = R.id.card_value
        //var l_card_lancamento = R.id.card_lancamento


        return view

        card!!.setBackgroundColor(ContextCompat.getColor(card!!.context,
                R.color.colorOrange))
        card_title!!.text = "Gastos"
    }

    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle?) =
                HomeFragment().apply {
                    arguments = bundle
                }
    }
}
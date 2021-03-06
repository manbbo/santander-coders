package com.example.snackbar.fragments

import android.R.attr.editable
import android.content.Context
import android.content.Intent
import android.icu.math.BigDecimal
import android.icu.text.NumberFormat
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.snackbar.R
import com.example.snackbar.domain.Gastos
import com.example.snackbar.fragments.spending.DetailGastosFragment
import com.example.snackbar.fragments.spending.DetailsGastosAdapter
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_spending.view.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class SpendingFragment: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var inflator = inflater.inflate(R.layout.fragment_spending, container, false)

        inflator.edValor.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            private var current: String = ""

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString() != current) {
                    inflator.edValor.removeTextChangedListener(this)

                    val cleanString: String = s.replace("[$,.]".toRegex(), "")

                    val parsed = cleanString.toDouble()
                    val formatted = NumberFormat.getCurrencyInstance().format((parsed/100))

                    current = formatted
                    inflator.edValor.setText(formatted)
                    inflator.edValor.setSelection(formatted.length)
                    inflator.edValor.addTextChangedListener(this)
                }
            }
        })

        inflator.edDataHora.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy H:mm")).toString())

        var intent = Intent(inflator.context,  DetailGastosFragment::class.java)

        inflator.btn_cadastrar.setOnClickListener {
            if (!inflator.edValor.text!!.isNullOrEmpty() &&
                    !inflator.edCategoria.text!!.isNullOrEmpty() &&
                !inflator.edDescricao.text!!.isNullOrEmpty()) {
                intent.putExtra("descricao", inflator.edDescricao.text.toString())
                intent.putExtra("categoria", inflator.edCategoria.text.toString())
                intent.putExtra("datahora", inflator.edDataHora.text.toString())
                intent.putExtra("valor", inflator.edValor.text.toString())
            }
        }

        inflator.btn_viewall.setOnClickListener {
            startActivity(intent)
        }

        return inflator
    }

    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle?) =
            SpendingFragment().apply {
                arguments = bundle
            }
    }
}
package com.example.snackbar.fragments

import android.icu.text.DateFormat
import android.icu.text.DecimalFormat
import android.icu.text.NumberFormat
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.snackbar.R
import kotlinx.android.synthetic.main.fragment_spending.*
import kotlinx.android.synthetic.main.fragment_spending.view.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder

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
                //Toast.makeText(SpendingFragment().context, "asdasd", Toast.LENGTH_SHORT).show()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            private var current: String = ""

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString() != current) {
                    inflator.edValor.removeTextChangedListener(this)

                    val cleanString: String = s.replace("""[R\$,.]""".toRegex(), "")

                    val parsed = cleanString.toDouble()
                    val formatted = NumberFormat.getCurrencyInstance().format((parsed / 100))

                    current = formatted
                    inflator.edValor.setText(formatted)
                    inflator.edValor.setSelection(formatted.length)
                    inflator.edValor.addTextChangedListener(this)
                }
            }
        })

        inflator.edDataHora.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy H:mm")).toString())

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
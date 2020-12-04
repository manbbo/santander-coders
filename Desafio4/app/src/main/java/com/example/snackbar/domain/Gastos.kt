package com.example.snackbar.domain

import java.io.Serializable
import java.time.LocalDateTime

data class Gastos (val descricao: String,
                   val categoria: String,
                   val data: String,
                   val valor: String) : Serializable {

}
package com.example.snackbar.domain

import java.io.Serializable
import java.time.LocalDateTime

data class Gastos (val descricao: String, val categoria: String,
                   val data: LocalDateTime = LocalDateTime.now(),
                   val valor: Float) : Serializable {

}
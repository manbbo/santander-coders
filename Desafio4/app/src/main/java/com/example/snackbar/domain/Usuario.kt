package com.example.snackbar.domain

import java.io.Serializable

data class Usuario (val id: Int,
                    val username: String, val senha: String) : Serializable {

}
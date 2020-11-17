package br.com.digitalhouse.desafio7_2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import br.com.digitalhouse.desafio7_2.viewmodels.MainViewModel
import br.com.digitalhouse.desafio7_2.ui.Desafio72Theme
import br.com.digitalhouse.desafio7_2.viewmodels.MovieViewModel

class MainActivity : AppCompatActivity() {
    private val viewModeler : MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Desafio72Theme {
                Scaffold(
                    topBar = { topBar() },
                    bodyContent = {
                        Box() {
                            LazyColumnFor(viewModeler.getListFilmes()) { item ->
                                Column(modifier = Modifier.clickable(onClick = {
                                    Toast.makeText(baseContext, "sdasd",
                                        Toast.LENGTH_SHORT).show() })) {

                                    Text(text = item.id.toString())

                                    Text(text = item.titulo)

                                    Text(text = item.sinopse)
                                }
                            }
                        }
                    },
                )
            }
        }
    }
}

@Composable
@Preview
fun topBar() {
    TopAppBar(
        title = { Text(text = "Filmes") })
}

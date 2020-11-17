package br.com.digitalhouse.desafio7_2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
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
                        Box(modifier = Modifier.fillMaxSize()) {
                            LazyColumnFor(viewModeler.getListFilmes()) { item ->
                                Column(modifier = Modifier.clickable(onClick = {
                                    Toast.makeText(baseContext, "${item.titulo}",
                                        Toast.LENGTH_SHORT).show() }).fillParentMaxWidth().height(100.dp).padding(vertical = 10.dp)) {

                                    Text(text = "ID: " + item.id.toString())

                                    Text(text = "TITULO: " + item.titulo)

                                    Text(text = "SINOPSE: " + item.sinopse)

                                }


                                Divider(thickness = 1.dp)
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
        title = { Text(text = "Filmes") },
        navigationIcon = { Icon(asset = Icons.Default.Home) })
}

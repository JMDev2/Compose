package com.example.freetoplay.ui.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.freetoplay.model.CharacterResponse

@Preview
@Composable
fun HomeScreen(){
    val characterViewModel = viewModel(modelClass = CharacterViewModel::class.java)
    val state by characterViewModel.state.collectAsState()

    LazyColumn(){
        if (state.isEmpty()){
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)

                )
            }
        }

        items(state){characterResponse: CharacterResponse ->
            CharacterImageCrad(characterResponse = characterResponse)
        }
    }
}

@Composable
fun CharacterImageCrad(characterResponse: CharacterResponse){
    val imagePainter = rememberImagePainter(data = characterResponse.image )

    Card(shape = MaterialTheme.shapes.medium,
    modifier = Modifier.padding(19.dp)){

        Box{

            Image(painter = imagePainter,
                contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.FillBounds

            )

            Surface(
                color = MaterialTheme.colors.onSurface.copy(alpha = .3f),
                modifier = Modifier.align(Alignment.BottomCenter),
                contentColor = MaterialTheme.colors.surface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Text(text = "Real name: ${characterResponse.actor}")
                    Text(text = "Actor name: ${characterResponse.name}")

                }

            }
        }
    }
}
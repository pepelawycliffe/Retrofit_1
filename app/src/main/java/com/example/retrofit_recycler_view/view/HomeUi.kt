package com.example.retrofit_recycler_view.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.CrossAxisAlignment.CenterCrossAxisAlignment.align
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.retrofit_recycler_view.model.Movie

@Composable
fun MovieItem(movie: Movie){

    Card (
        border = BorderStroke(1.dp, Color.Blue),
        modifier = Modifier
            .padding(12.dp, 8.dp, 8.dp, 12.dp)
            .fillMaxWidth()
            .height(110.dp),
        shape = RoundedCornerShape(8.dp)

        ){
        Surface {
            Row (modifier = Modifier
                .padding(8.dp)
                .fillMaxSize())
            {
                Card (modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.2f)
                    .padding(0.dp,0.dp,4.dp)
                    .weight(0.2f)

                    ){
                    Image(painter = rememberImagePainter(data = movie.imageUrl,
                        builder ={
                            scale(Scale.FILL)
                            transformations()
//                            transformations(CircleCropTransformation())
                        }), contentDescription =movie.desc
                        ,modifier = Modifier
                            .fillMaxHeight()
                            .weight(0.2f),
                        alignment =Alignment.Center,
//                        alpha = 0.2f,
                    )
                }

               Card(
                   modifier = Modifier
                       .background(color = Color.LightGray)
                       .fillMaxSize()
                       .weight(0.8f)
                   ,shape = RoundedCornerShape(4.dp)
                   ,border = BorderStroke(1.dp, Color.Gray),) {
                   Column (
                       verticalArrangement = Arrangement.Center,
                       modifier = Modifier
                           .padding(4.dp)
//                           .weight(0.8f)
                   )
                   {
                       Text(text = movie.name,
                           style = MaterialTheme.typography.titleMedium,
                           modifier = Modifier
                               .padding(4.dp)
                               .fillMaxWidth()
//                            .background(Color.LightGray)
                           ,
                           fontWeight = FontWeight.Normal,
                           overflow = TextOverflow.Ellipsis,
                       )
                       Text(
                           text = movie.category,
                           style = MaterialTheme.typography.titleMedium,
                           modifier = Modifier
                               .padding(4.dp)

                       )
                       Text(
                           text = movie.desc,
                           style = MaterialTheme.typography.titleSmall,
                           modifier = Modifier, maxLines = 2


                       )

                   }
               }

            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val movie=Movie("marvel","","Reliable faiths lead to the mineral.","science fiction")
    MovieItem(movie = movie)
}
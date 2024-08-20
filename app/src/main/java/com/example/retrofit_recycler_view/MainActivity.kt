package com.example.retrofit_recycler_view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.retrofit_recycler_view.model.Movie
import com.example.retrofit_recycler_view.ui.theme.RetrofitRecyclerviewTheme
import com.example.retrofit_recycler_view.view.MovieItem
import com.example.retrofit_recycler_view.viewModel.MovieViewModel

class MainActivity : ComponentActivity() {

    val movieViewModel by viewModels<MovieViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface()
            {
                MovieList(movieList = movieViewModel.movieListResponse)
                movieViewModel.getMovieList()
            }
        }
    }
}

@Composable
fun MovieList(movieList: List<Movie>){
    LazyColumn {
        itemsIndexed(items = movieList){index,item->
            MovieItem(movie = item)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val movie=Movie("marvel","","Reliable faiths lead to the mineral.","science fiction")
    MovieItem(movie = movie)
}
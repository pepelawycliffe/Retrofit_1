package com.example.retrofit_recycler_view.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_recycler_view.model.Movie
import com.example.retrofit_recycler_view.network.ApiServices
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {
    var movieListResponse:List<Movie> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getMovieList(){
        viewModelScope.launch {
            val apiService=ApiServices.getInstance()
            try {
             var  movieList=apiService.getMovies()
                movieListResponse=movieList
            }catch (e:Exception){
                errorMessage=e.message.toString()
            }
        }
    }
}
package com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.framework.viewmodel

import Movie
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.framework.api.MovieRestApiTask
import com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.data.MovieRepository
import com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.implementations.MovieDataSourceImplementation
import com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.usecase.MoviesListUseCase

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    mvvm-cleanarchitecture-everis-digitalinovationone
 *  Date:       22/02/2021
 */

class MovieListViewModel : ViewModel() {

    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSource = MovieDataSourceImplementation(movieRestApiTask)
    private val movieRepository = MovieRepository(movieDataSource)
    private val movieListUseCase = MoviesListUseCase(movieRepository)

    private var _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
        get() = _movieList

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread {
            try {
                _movieList.postValue(movieListUseCase.invoke())
            } catch (exception: Exception) {
                Log.d(TAG, exception.toString())
            }
        }.start()
    }

    companion object {
        const val TAG = "MovieListViewModel"
    }
}
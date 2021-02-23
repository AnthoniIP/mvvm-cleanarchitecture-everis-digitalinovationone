package com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.viewmodel

import Movie
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.api.MovieRestApiTask
import com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.repository.MovieRepository

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    mvvm-cleanarchitecture-everis-digitalinovationone
 *  Date:       22/02/2021
 */

class MovieListViewModel : ViewModel() {

    private val movieRestApiTask = MovieRestApiTask()
    private val movieRepository = MovieRepository(movieRestApiTask)

    private var _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
        get() = _movieList

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread {
            try {
                _movieList.postValue(movieRepository.getAllMovies())
            } catch (exception: Exception) {
                Log.d(TAG, exception.toString())
            }
        }.start()
    }

    companion object {
        const val TAG = "MovieListViewModel"
    }
}
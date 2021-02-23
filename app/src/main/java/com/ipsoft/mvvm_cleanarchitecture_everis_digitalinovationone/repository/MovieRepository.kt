package com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.repository

import Movie
import android.util.Log
import com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.api.MovieRestApiTask

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    mvvm-cleanarchitecture-everis-digitalinovationone
 *  Date:       23/02/2021
 */

class MovieRepository(private val movieRestApiTask: MovieRestApiTask) {

    private val movieList = arrayListOf<Movie>()
    fun getAllMovies(): List<Movie> {

        val request = movieRestApiTask.retrofitApi().getAllMovies().execute()
        if (request.isSuccessful) {
            request.body()?.let {
                movieList.addAll(it)
            }
        } else {
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }

        }
        return movieList
    }

    companion object {
        const val TAG = "MovieRepository"
    }
}
package com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.implementations

import Movie
import android.util.Log
import com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.framework.api.MovieRestApiTask
import com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.data.MovieDataSource


/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    mvvm-cleanarchitecture-everis-digitalinovationone
 *  Date:       23/02/2021
 */

class MovieDataSourceImplementation(private val movieRestApiTask: MovieRestApiTask) :
    MovieDataSource {

    private val movieList = arrayListOf<Movie>()

    override fun getAllMovies(): List<Movie> {
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
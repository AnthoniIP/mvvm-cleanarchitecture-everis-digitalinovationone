package com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.api

import Movie
import retrofit2.Call
import retrofit2.http.GET

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    mvvm-cleanarchitecture-everis-digitalinovationone
 *  Date:       22/02/2021
 */

interface MovieApi {
    //https://raw.githubusercontent.com/natanfelipe/FilmesFlixJson/master/moviesList

    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovies(): Call<List<Movie>>
}
package com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.data

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    mvvm-cleanarchitecture-everis-digitalinovationone
 *  Date:       23/02/2021
 */

class MovieRepository(private val movieDataSource: MovieDataSource) {
    fun getAllMoviesFromDataSource() = movieDataSource.getAllMovies()
}
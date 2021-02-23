package com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.data

import Movie

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    mvvm-cleanarchitecture-everis-digitalinovationone
 *  Date:       23/02/2021
 */

interface MovieDataSource {

    fun getAllMovies(): List<Movie>
}
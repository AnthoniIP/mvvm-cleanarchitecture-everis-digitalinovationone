package com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.usecase

import com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.data.MovieRepository

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    mvvm-cleanarchitecture-everis-digitalinovationone
 *  Date:       23/02/2021
 */

class MoviesListUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke() = movieRepository.getAllMoviesFromDataSource()
}
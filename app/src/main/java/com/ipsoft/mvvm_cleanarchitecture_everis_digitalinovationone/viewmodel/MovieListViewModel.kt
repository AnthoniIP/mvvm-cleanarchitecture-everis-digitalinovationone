package com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.viewmodel

import Movie
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    mvvm-cleanarchitecture-everis-digitalinovationone
 *  Date:       22/02/2021
 */

class MovieListViewModel : ViewModel() {
    private val listOfMovies = arrayListOf(
        Movie(
            id = 0,
            titulo = "titanic",
            descricao = null,
            imagem = null,
            dataLancamento = null
        ),
        Movie(
            id = 1,
            titulo = "central do brasil",
            descricao = null,
            imagem = null,
            dataLancamento = null
        )
    )
    private var _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
        get() = _movieList

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        _movieList.value = listOfMovies
    }
}
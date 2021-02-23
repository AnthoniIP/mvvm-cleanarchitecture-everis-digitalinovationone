package com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.view

import Movie
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.databinding.ActivityMainBinding
import com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.viewmodel.MovieListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieListViewModel: MovieListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        movieListViewModel =
            ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieListViewModel.init()
        initObservers()
        loadingVisibility(true)
    }

    private fun initObservers() {
        movieListViewModel.movieList.observe(this, { listMovies ->
            if (listMovies.isNotEmpty()) {
                populateList(listMovies)
                loadingVisibility(false)
            } else {
                loadingVisibility(true)
            }

        })
    }

    private fun populateList(listMovies: List<Movie>) {
        binding.moviesListRecyclerView.apply {
            hasFixedSize()
            adapter = MoviesAdapter(listMovies)
        }
    }

    private fun loadingVisibility(isLoading: Boolean) {

        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}
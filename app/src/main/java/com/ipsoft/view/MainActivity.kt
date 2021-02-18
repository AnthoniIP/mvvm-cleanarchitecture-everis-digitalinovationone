package com.ipsoft.view

import Movie
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        populateList()
    }

    private fun populateList() {
        binding.moviesListRecyclerView.apply {
            hasFixedSize()
            adapter = MoviesAdapter(listOfMovies)
        }
    }
}
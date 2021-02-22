package com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.view

import Movie
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.R
import com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.databinding.MovieItemLayoutBinding

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    mvvm-cleanarchitecture-everis-digitalinovationone
 *  Date:       18/02/2021
 */

class MoviesAdapter(private val moviesList: List<Movie>) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private lateinit var binding: MovieItemLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        binding = MovieItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val view =
            binding.root
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.itemView.apply {
            binding.movieTitle.text = moviesList[position].titulo
            binding.movieImage.load(moviesList[position].imagem) {
                placeholder(R.drawable.ic_image)
                fallback(R.drawable.ic_image)
            }
        }
    }

    override fun getItemCount(): Int = moviesList.size

    inner class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
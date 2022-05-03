package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.MovieItemBinding
import com.example.movieapp.listeners.MovieClick
import com.example.movieapp.model.Movie

class MovieAdapter(private val moviesList: MutableList<Movie>, private val itemClick: MovieClick) :
    RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MyViewHolder {
        val itemBinding =
            MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MyViewHolder, position: Int) {
        val movie: Movie = moviesList[position]
        holder.bind(movie,itemClick)
    }

    override fun getItemCount(): Int = moviesList.size

    class MyViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie, itemClick: MovieClick) {

        }
    }


}
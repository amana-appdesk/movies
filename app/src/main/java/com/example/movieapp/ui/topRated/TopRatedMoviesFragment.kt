package com.example.movieapp.ui.topRated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.adapter.MovieAdapter
import com.example.movieapp.databinding.FragmentTopRatedBinding
import com.example.movieapp.listeners.MovieClick
import com.example.movieapp.model.Movie
import com.example.movieapp.network.Status
import com.example.movieapp.utils.hide
import com.example.movieapp.utils.show
import com.example.movieapp.utils.snack
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopRatedMoviesFragment : Fragment(), MovieClick {

    private var moviesList = mutableListOf<Movie>()
    private var _binding: FragmentTopRatedBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private val viewModel : TopRatedMoviesViewModel by viewModels()
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[TopRatedMoviesViewModel::class.java]

        return FragmentTopRatedBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(binding.root)
        movieAdapter = MovieAdapter(moviesList,this)

        binding.topRatedMoviesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.topRatedMoviesRecyclerView.setHasFixedSize(true)
        binding.topRatedMoviesRecyclerView.adapter = movieAdapter

        fetchMovies()
    }

    private fun fetchMovies() {
        moviesList.clear()
        viewModel.getTopRatedMovies().observe(requireActivity()) { res ->
            run {
                when (res.status) {
                    Status.LOADING -> {
                        binding.progressBar.show()
                    }
                    Status.SUCCESS -> {
                        binding.progressBar.hide()
                        moviesList.addAll(res.data?.results?.toMutableList()!!)
                        movieAdapter.notifyDataSetChanged()
                    }
                    Status.ERROR -> {
                        binding.progressBar.hide()
                        requireView().snack(res.msg.toString())
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun movieClick(position: Int,movieType: String) {

    }
}
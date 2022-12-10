package com.example.task_final_s5.ui

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.task_final_s5.R
import com.example.task_final_s5.adapter.MovieAdapter
import com.example.task_final_s5.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args: DetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            Glide.with(view)
                .load(MovieAdapter.posterBaseUrl + args.movie.backdropPath)
                .into(ivBackdrop)
            Glide.with(view)
                .load(MovieAdapter.posterBaseUrl + args.movie.posterPath)
                .into(ivPoster)
            tvTitle.text = args.movie.title
            tvOverview.text = args.movie.overview
            tvReleaseDate.text = args.movie.releaseDate
            tvAverageRating.text = args.movie.voteAverage.toString()
            tvRateCount.text = args.movie.voteCount.toString()
            tvPopularity.text = args.movie.popularity.toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
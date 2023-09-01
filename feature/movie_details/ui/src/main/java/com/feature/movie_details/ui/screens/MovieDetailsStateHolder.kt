package com.feature.movie_details.ui.screens

import com.feature.movie_details.domain.model.MovieDetails

data class MovieDetailsStateHolder(
    val isLoading:Boolean=false,
    val error: String = "",
    val data: MovieDetails?=null
)

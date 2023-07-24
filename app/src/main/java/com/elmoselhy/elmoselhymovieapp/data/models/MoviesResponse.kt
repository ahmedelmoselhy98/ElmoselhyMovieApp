package com.elmoselhy.elmoselhymovieapp.data.models

import com.google.gson.annotations.SerializedName


data class MoviesResponse(
    @SerializedName("results") var results: ArrayList<Movie> = arrayListOf(),
    @SerializedName("page") var page: Int? = null,
    @SerializedName("total_pages") var totalPages: Int? = null,
    @SerializedName("total_results") var totalResults: Int? = null
)
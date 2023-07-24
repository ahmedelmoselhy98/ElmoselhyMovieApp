package com.elmoselhy.elmoselhymovieapp.data.models

import com.google.gson.annotations.SerializedName

class Movie(
    @SerializedName("id")
    private var id: Int,
    @SerializedName("popularity")
    private val popularity: Double,
    @SerializedName("vote_average")
    private var voteAverage: Double,
    @SerializedName("vote_count")
    private val voteCount: Int,
    @SerializedName("poster_path")
    private val posterPath: String? = null,
    @SerializedName("backdrop_path")
    private var backdropPath: String? = null,
    @SerializedName("original_language")
    private var originalLanguage: String? = null,
    @SerializedName("original_title")
    private var originalTitle: String? = null,
    @SerializedName("title")
    private var title: String? = null,
    @SerializedName("overview")
    private var overview: String? = null,
    @SerializedName("release_date")
    private var releaseDate: String? = null,
    @SerializedName("adult")
    private val adult: Boolean = false,
    @SerializedName("video")
    private var video: Boolean = false,
    @SerializedName("genre_ids")
    private val genreIds: IntArray
)
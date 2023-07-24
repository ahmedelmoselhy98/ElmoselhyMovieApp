package com.elmoselhy.elmoselhymovieapp.data.repositories

import com.elmoselhy.elmoselhymovieapp.data.models.MoviesResponse
import retrofit2.Response
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesRepository {
    suspend fun fetchMovies(
        movieCriteria: String?,
        apiKey: String,
        language: String?,
        page: Int
    ):Response<MoviesResponse>
}
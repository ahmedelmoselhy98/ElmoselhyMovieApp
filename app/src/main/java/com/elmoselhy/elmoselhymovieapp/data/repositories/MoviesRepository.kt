package com.elmoselhy.elmoselhymovieapp.data.repositories

import com.elmoselhy.elmoselhymovieapp.data.models.MoviesResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

interface MoviesRepository {
    suspend fun fetchMovies(
        movieCriteria: String?,
        apiKey: String,
        language: String?,
        page: Int
    ) : Flow<Response<MoviesResponse>>
}
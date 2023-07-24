package com.elmoselhy.elmoselhymovieapp.data.repositories

import com.elmoselhy.elmoselhymovieapp.data.apis.MovieApi
import javax.inject.Inject

class MoviesRepositoryImp @Inject constructor(private val movieApi: MovieApi) : MoviesRepository {
    override suspend fun fetchMovies(
        movieCriteria: String?,
        apiKey: String,
        language: String?,
        page: Int
    ) = movieApi.getMovies(movieCriteria, apiKey, language, page)

}
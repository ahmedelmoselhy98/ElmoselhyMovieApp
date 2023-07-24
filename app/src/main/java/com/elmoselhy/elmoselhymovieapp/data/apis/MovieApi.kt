package com.elmoselhy.elmoselhymovieapp.data.apis

import com.elmoselhy.elmoselhymovieapp.data.models.Movie
import com.elmoselhy.elmoselhymovieapp.data.models.MoviesResponse
import retrofit2.Response
import retrofit2.http.*


interface MovieApi {

    //Get a list of the current {criteria} movies on TMDb. This list updates daily.
    //criteria : popular,top_rated,now_playing,upcoming,now_playing
    @GET("movie/{movie_criteria}")
    suspend fun getMovies(
        @Path("movie_criteria") movieCriteria: String?,
        @Query("api_key") apiKey: String,
        @Query("language") language: String?,
        @Query("page") page: Int
    ): Response<MoviesResponse>


}
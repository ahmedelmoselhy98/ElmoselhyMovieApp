package com.elmoselhy.elmoselhymovieapp.di

import com.elmoselhy.elmoselhymovieapp.data.repositories.MoviesRepository
import com.elmoselhy.elmoselhymovieapp.data.repositories.MoviesRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideMovieRepository(moviesRepositoryImp: MoviesRepositoryImp): MoviesRepository

}
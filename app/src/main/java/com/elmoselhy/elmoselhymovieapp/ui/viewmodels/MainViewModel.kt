package com.elmoselhy.elmoselhymovieapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.elmoselhy.elmoselhymovieapp.BuildConfig
import com.elmoselhy.elmoselhymovieapp.utilities.Constants
import com.elmoselhy.elmoselhymovieapp.data.repositories.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


data class MainUiState(
    val id: String? = null,
    val name: String? = null,
    val rate: Double? = null,
    val imageUrl: String? = null,
)

sealed class NetworkState {
    object Loading : NetworkState()
    object StopLoading : NetworkState()
    object Idle : NetworkState()
    data class Success<T>(val data: T) : NetworkState()
    data class Error(val throwable: Throwable) : NetworkState()
}


@HiltViewModel
class MainViewModel @Inject constructor(private val moviesRepository: MoviesRepository) :
    ViewModel() {

    private val TAG = "MainViewModel"
    private val _uiState = MutableSharedFlow<NetworkState>()
    val uiState: SharedFlow<NetworkState> = _uiState.asSharedFlow()

    fun getMovies() {
        viewModelScope.launch {
            val movieFlow =
                moviesRepository.fetchMovies(Constants.popular, BuildConfig.API_KEY, "en", 1)
            movieFlow.onStart { }.onCompletion { }.catch { }.collectLatest {
                _uiState.emit(NetworkState.Success(it.body()?.results))
            }
        }
//        _uiState.update { currentState ->
//            currentState.copy(
//                id = "1",
//                name = "Ahmed",
//                rate = 3.4,
//                imageUrl = "https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8aHVtYW58ZW58MHx8MHx8fDA%3D&w=1000&q=80"
//            )
//        }
    }
//
//    companion object{
//        val Factory:ViewModelProvider.Factory = object : ViewModelProvider.Factory {
//            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
//                val application = checkNotNull(extras[APPLICATION_KEY])
//                val savedStateHandle = extras.createSavedStateHandle()
//
//                return super.create(modelClass, extras)
//            }
//        }
//    }

    override fun onCleared() {
        super.onCleared()
    }
}
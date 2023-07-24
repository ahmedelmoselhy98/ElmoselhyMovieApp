package com.elmoselhy.elmoselhymovieapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.*
import com.elmoselhy.elmoselhymovieapp.ui.viewmodels.MainViewModel
import com.elmoselhy.elmoselhymovieapp.R
import com.elmoselhy.elmoselhymovieapp.ui.viewmodels.NetworkState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModelScopedToThisViewModeStoreOwner by viewModels<MainViewModel>()
    lateinit var coreMainViewModelScopedToThisViewModeStoreOwner: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        coreMainViewModelScopedToThisViewModeStoreOwner =
            ViewModelProvider(this)[MainViewModel::class.java]

        coreMainViewModelScopedToThisViewModeStoreOwner.getMovies()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                coreMainViewModelScopedToThisViewModeStoreOwner.uiState.collect{networkState->
                    when(networkState){
                        is NetworkState.Error -> {}
                        NetworkState.Idle -> {}
                        NetworkState.Loading -> {}
                        NetworkState.StopLoading -> {}
                        is NetworkState.Success<*> -> {
                            networkState.data
                        }
                    }
                }
//                mainViewModelScopedToThisViewModeStoreOwner.uiState.collect {
//                }
            }
        }
    }
}
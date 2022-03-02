package com.rvery.presenter.catsgrid

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rvery.domain.GetPictureOfCatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GridCatsViewModel @Inject constructor(
    private val getPictureOfCatsUseCase: GetPictureOfCatsUseCase
) : ViewModel() {

    fun getPictureOfCats() {
        viewModelScope.launch {
            getPictureOfCatsUseCase.getPictureOfCats()
                .catch { exception ->

                }
                .collect {
                    Log.d("Test", "test ${it.size}")
                }
        }
    }

}
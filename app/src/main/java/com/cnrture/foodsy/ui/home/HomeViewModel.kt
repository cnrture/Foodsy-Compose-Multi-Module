package com.cnrture.foodsy.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cnrture.foodsy.delegation.MVI
import com.cnrture.foodsy.delegation.mvi
import com.cnrture.foodsy.ui.home.HomeContract.UiAction
import com.cnrture.foodsy.ui.home.HomeContract.UiEffect
import com.cnrture.foodsy.ui.home.HomeContract.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel(), MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
        }
    }
}
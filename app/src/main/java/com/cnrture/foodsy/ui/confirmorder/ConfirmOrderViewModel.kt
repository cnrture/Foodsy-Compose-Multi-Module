package com.cnrture.foodsy.ui.confirmorder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cnrture.foodsy.delegation.MVI
import com.cnrture.foodsy.delegation.mvi
import com.cnrture.foodsy.ui.confirmorder.ConfirmOrderContract.UiAction
import com.cnrture.foodsy.ui.confirmorder.ConfirmOrderContract.UiEffect
import com.cnrture.foodsy.ui.confirmorder.ConfirmOrderContract.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfirmOrderViewModel @Inject constructor() : ViewModel(), MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
        }
    }
}
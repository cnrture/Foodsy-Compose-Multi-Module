package com.canerture.foodsy.ui.orders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.foodsy.delegation.MVI
import com.canerture.foodsy.delegation.mvi
import com.canerture.foodsy.ui.orders.OrdersContract.UiAction
import com.canerture.foodsy.ui.orders.OrdersContract.UiEffect
import com.canerture.foodsy.ui.orders.OrdersContract.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrdersViewModel @Inject constructor() : ViewModel(), MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
        }
    }
}
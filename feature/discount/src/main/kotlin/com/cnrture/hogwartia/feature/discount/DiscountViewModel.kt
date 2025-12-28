package com.cnrture.hogwartia.feature.discount

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.hogwartia.ui.delegate.mvi.MVI
import com.canerture.hogwartia.ui.delegate.mvi.mvi
import com.canerture.hogwartia.ui.delegate.navigator.NavigationClient
import com.canerture.hogwartia.ui.delegate.navigator.navigationClient
import com.cnrture.hogwartia.feature.discount.DiscountContract.UiAction
import com.cnrture.hogwartia.feature.discount.DiscountContract.UiEffect
import com.cnrture.hogwartia.feature.discount.DiscountContract.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscountViewModel @Inject constructor() :
    ViewModel(),
    MVI<UiState, UiAction, UiEffect> by mvi(UiState()),
    NavigationClient by navigationClient() {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
        }
    }
}
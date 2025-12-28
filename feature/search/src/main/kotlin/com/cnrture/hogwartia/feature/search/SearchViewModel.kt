package com.cnrture.hogwartia.feature.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.ui.delegate.mvi.MVI
import com.canerture.ui.delegate.mvi.mvi
import com.canerture.ui.delegate.navigator.NavigationClient
import com.canerture.ui.delegate.navigator.navigationClient
import com.cnrture.hogwartia.feature.search.SearchContract.UiAction
import com.cnrture.hogwartia.feature.search.SearchContract.UiEffect
import com.cnrture.hogwartia.feature.search.SearchContract.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor() :
    ViewModel(),
    MVI<UiState, UiAction, UiEffect> by mvi(UiState()),
    NavigationClient by navigationClient() {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
        }
    }
}
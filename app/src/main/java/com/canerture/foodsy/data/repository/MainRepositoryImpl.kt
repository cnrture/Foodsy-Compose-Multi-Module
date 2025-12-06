package com.canerture.foodsy.data.repository

import com.canerture.foodsy.data.remote.MainService
import com.canerture.foodsy.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainService: MainService,
) : MainRepository
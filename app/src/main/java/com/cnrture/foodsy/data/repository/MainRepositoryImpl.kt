package com.cnrture.foodsy.data.repository

import com.cnrture.foodsy.data.remote.MainService
import com.cnrture.foodsy.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainService: MainService,
) : MainRepository
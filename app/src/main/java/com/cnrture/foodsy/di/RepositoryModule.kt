package com.cnrture.foodsy.di

import com.cnrture.foodsy.data.repository.MainRepositoryImpl
import com.cnrture.foodsy.domain.repository.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMainRepository(repositoryImpl: MainRepositoryImpl): MainRepository
}
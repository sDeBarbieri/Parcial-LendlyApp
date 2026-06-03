package com.example.parciallendlyapp.di

import com.example.parciallendlyapp.data.repository.ShopRepositoryImpl
import com.example.parciallendlyapp.domain.repository.ShopRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindShopRepository(
        shopRepositoryImpl: ShopRepositoryImpl
    ): ShopRepository
}
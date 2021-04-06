package com.example.mercado.di.module

import com.example.data.item.ItemDataRepository
import com.example.domain.item.ItemRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindDataRepository(dataRepository: ItemDataRepository): ItemRepository

}
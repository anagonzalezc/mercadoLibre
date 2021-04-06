package com.example.data.item.store

import com.example.data.item.repository.ItemDataStore
import javax.inject.Inject

class ItemDataStoreFactory @Inject constructor(
    private val musicRemoteDataStore: ItemRemoteDataStore
) {

    open fun getRemoteDataStore(): ItemDataStore {
        return musicRemoteDataStore
    }

}
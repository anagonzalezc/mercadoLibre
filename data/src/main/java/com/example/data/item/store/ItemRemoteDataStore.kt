package com.example.data.item.store

import com.example.data.item.model.ItemEntity
import com.example.data.item.repository.ItemDataStore
import com.example.data.item.repository.ItemRemote
import io.reactivex.Single
import javax.inject.Inject

class ItemRemoteDataStore @Inject constructor(
    private val itemRemote: ItemRemote
)
    : ItemDataStore {

    override fun findItemByText(text: String?): Single<List<ItemEntity>> {
        return itemRemote.findItemByText(text)
    }
}
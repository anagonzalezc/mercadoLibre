package com.example.data.item.repository

import com.example.data.item.model.ItemEntity
import io.reactivex.Single

interface ItemDataStore {

    fun findItemByText(text: String?): Single<List<ItemEntity>>

}
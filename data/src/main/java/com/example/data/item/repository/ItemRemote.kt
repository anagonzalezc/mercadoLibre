package com.example.data.item.repository

import com.example.data.item.model.ItemEntity
import io.reactivex.Single

interface ItemRemote {

    fun findItemByText(text: String?): Single<List<ItemEntity>>

}
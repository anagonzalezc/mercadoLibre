package com.example.domain.item

import com.example.domain.item.model.Item
import io.reactivex.Single

interface ItemRepository {

    fun findItemByText(text: String?): Single<List<Item>>

}
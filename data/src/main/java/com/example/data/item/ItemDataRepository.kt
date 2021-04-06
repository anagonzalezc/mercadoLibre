package com.example.data.item

import com.example.data.item.store.ItemDataStoreFactory
import com.example.domain.item.ItemRepository
import com.example.domain.item.model.Item
import io.reactivex.Single
import javax.inject.Inject

class ItemDataRepository @Inject constructor(
    private val mapper: ItemMapper,
    private val factory: ItemDataStoreFactory
)
    : ItemRepository {

    override fun findItemByText(text: String?): Single<List<Item>> {
        return factory.getRemoteDataStore().findItemByText(text).map {
            it.map {
                mapper.mapFromEntity(it)
            }
        }

    }

}
package com.example.remote.item

import com.example.data.item.model.ItemEntity
import com.example.data.item.repository.ItemRemote
import io.reactivex.Single
import javax.inject.Inject

class ItemRemoteImpl @Inject constructor(
    private val restApi: SearchRestApi,
    private val mapper: ItemRemoteMapper
)
    : ItemRemote {

    override fun findItemByText(text: String?): Single<List<ItemEntity>> {
        return restApi.getItem(text).map { search ->
            search.searches.map { mapper.mapFromRemote(it) }
        }
    }

}
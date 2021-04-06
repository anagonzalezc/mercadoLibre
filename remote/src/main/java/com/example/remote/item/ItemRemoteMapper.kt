package com.example.remote.item

import com.example.data.item.model.ItemEntity
import com.example.remote.RemoteMapper
import com.example.remote.item.model.RemoteItem
import javax.inject.Inject

class ItemRemoteMapper @Inject constructor() : RemoteMapper<RemoteItem, ItemEntity> {

    override fun mapFromRemote(remote: RemoteItem): ItemEntity {
        return ItemEntity(
            remote.id,
            remote.title,
            remote.price,
            remote.condition,
            remote.thumbnail,
            remote.permalink,
            remote.available_quantity,
            remote.installments?.amount,
            remote.installments?.quantity,
            remote.installments?.rate
        )
    }

}
package com.example.data.item

import com.example.data.EntityMapper
import com.example.data.item.model.InstallmentsEntity
import com.example.data.item.model.ItemEntity
import com.example.domain.item.model.Installments
import com.example.domain.item.model.Item
import javax.inject.Inject

class ItemMapper @Inject constructor() : EntityMapper<ItemEntity, Item> {

    override fun mapFromEntity(entity: ItemEntity): Item {
        return Item(
            entity.title,
            entity.title,
            entity.price,
            entity.listing_type_id,
            entity.thumbnail,
            entity.permalink,
            entity.available_quantity,
            entity.amount,
            entity.rate,
            entity.quantity,
            entity.interest
        )
    }

    override fun mapToEntity(domain: Item): ItemEntity {
        return ItemEntity(
            domain.id,
            domain.title,
            domain.price,
            domain.listing_type_id,
            domain.thumbnail,
            domain.permalink,
            domain.available_quantity,
            domain.amount,
            domain.rate,
            domain.quantity,
            domain.interest
        )
    }


}
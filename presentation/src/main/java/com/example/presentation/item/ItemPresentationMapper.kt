package com.example.presentation.item

import com.example.domain.item.model.Item
import com.example.presentation.PresentationMapper
import com.example.presentation.item.model.ItemPresentation
import javax.inject.Inject

open class ItemPresentationMapper @Inject constructor() :
    PresentationMapper<ItemPresentation, Item> {

    override fun mapToPresentation(domain: Item): ItemPresentation {
        return ItemPresentation(
            domain.id,
            domain.title,
            domain.price,
            domain.listing_type_id,
            domain.thumbnail,
            domain.permalink,
            domain.available_quantity,
            domain.amount,
            domain.quantity,
            domain.rate,
            domain.interest
        )
    }

    override fun mapFromPresentation(presentation: ItemPresentation): Item {
        return Item(
            presentation.id,
            presentation.title,
            presentation.price,
            presentation.content,
            presentation.thumbnail,
            presentation.permalink,
            presentation.available_quantity,
            presentation.amount,
            presentation.rate,
            presentation.quantity,
            presentation.interest
        )
    }

}
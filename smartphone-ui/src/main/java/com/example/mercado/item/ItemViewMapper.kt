package com.example.mercado.item

import com.example.mercado.ViewMapper
import com.example.mercado.item.model.ItemView
import com.example.presentation.item.model.ItemPresentation
import javax.inject.Inject
import kotlin.math.roundToInt

class ItemViewMapper @Inject constructor() : ViewMapper<ItemPresentation, ItemView> {

    override fun mapToView(presentation: ItemPresentation): ItemView {
        return ItemView(
            presentation.id,
            presentation.title,
            presentation.price?.roundToInt().toString(),
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

    override fun mapFromView(view: ItemView): ItemPresentation {
        TODO("Not yet implemented")
    }

}
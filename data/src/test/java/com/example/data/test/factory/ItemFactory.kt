package com.example.data.test.factory

import com.example.data.item.model.ItemEntity
import com.example.domain.item.model.Item
import com.segtechcu.data.test.factory.DataFactory

object ItemFactory {

    fun makeItemEntity(): ItemEntity {
        return ItemEntity(
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomFloat(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomFloat(),
            DataFactory.randomInt(),
            DataFactory.randomInt(),
            DataFactory.randomString()

        )
    }
}
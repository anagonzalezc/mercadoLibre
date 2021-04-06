package com.example.domain.test

import com.example.domain.item.model.Item
import java.util.*

object ItemDataFactory {

    fun makeItemList(count: Int): List<Item> {
        val item = mutableListOf<Item>()
        repeat(count) {
            item.add(makeItem())
        }
        return item
    }

    fun makeItem(): Item {
        return Item(
            randomUuid(),
            randomUuid(),
            randomFloat(),
            randomUuid(),
            randomUuid(),
            randomUuid(),
            randomUuid(),
            randomFloat(),
            randomInt(),
            randomInt(),
            randomUuid()
        )
    }
    fun randomUuid(): String {
        return UUID.randomUUID().toString()
    }

    fun randomFloat(): Float {
        return randomFloat()
    }

    fun randomInt(): Int {
        return randomInt()
    }
}
package com.example.remote.test.factory

import com.example.data.item.model.ItemEntity
import com.example.remote.item.model.InstallmentsRemote
import com.example.remote.item.model.RemoteItem
import com.example.remote.item.model.RemoteSearch


object ItemDataFactory {

    fun makeItemResponse(): RemoteSearch {
        return RemoteSearch(makeListOfItem())
    }

    fun makeListOfItem(): List<RemoteItem> {
        return listOf(makeItem(), makeItem())
    }

    fun makeInstallmentsResponse(): InstallmentsRemote {
        return makeListOfInstallments()
    }

    fun makeItem(): RemoteItem {
        return RemoteItem(
            DataFactory.randomUuid(),
            DataFactory.randomUuid(),
            DataFactory.randomFloat(),
            DataFactory.randomUuid(),
            DataFactory.randomUuid(),
            DataFactory.randomUuid(),
            DataFactory.randomUuid(),
            makeInstallmentsResponse(),
            DataFactory.randomUuid()
        )
    }

    fun makeItemEntity(): ItemEntity {
        return ItemEntity(
            DataFactory.randomUuid(),
            DataFactory.randomUuid(),
            DataFactory.randomFloat(),
            DataFactory.randomUuid(),
            DataFactory.randomUuid(),
            DataFactory.randomUuid(),
            DataFactory.randomUuid(),
            DataFactory.randomFloat(),
            DataFactory.randomInt(),
            DataFactory.randomInt(),
            DataFactory.randomUuid()

        )
    }

    fun makeListOfInstallments(): InstallmentsRemote{
        return InstallmentsRemote(
            DataFactory.randomInt(),
            DataFactory.randomFloat(),
            DataFactory.randomInt()
        )
    }

}
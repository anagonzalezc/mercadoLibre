package com.example.remote.item

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.example.data.item.model.ItemEntity
import com.example.remote.item.model.RemoteItem
import com.example.remote.item.model.RemoteSearch
import com.example.remote.test.factory.DataFactory
import com.example.remote.test.factory.ItemDataFactory
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ItemRemoteImplTest {

    private val mapper = mock<ItemRemoteMapper>()
    private val restApi = mock<SearchRestApi>()
    private val remote = ItemRemoteImpl(restApi, mapper)


    @Test
    fun getClientCompletes() {
        val param = DataFactory.randomUuid()
        stubClientRestApiClients(Single.just(ItemDataFactory.makeItemResponse()), param)
        stubClientResponseModelMapperMapFromModel(any(), ItemDataFactory.makeItemEntity())

        val testObserver = remote.findItemByText(param).test()
        testObserver.assertComplete()
    }

    @Test
    fun getClientCallsServer() {
        val param = DataFactory.randomUuid()
        stubClientRestApiClients(Single.just(ItemDataFactory.makeItemResponse()), param)
        stubClientResponseModelMapperMapFromModel(any(), ItemDataFactory.makeItemEntity())

        remote.findItemByText(param).test()
        verify(restApi).getItem(param)
    }

    @Test
    fun getClientReturnsData() {
        val param = DataFactory.randomUuid()
        val response = ItemDataFactory.makeItemResponse()
        stubClientRestApiClients(Single.just(response), param)
        val entities = mutableListOf<ItemEntity>()
        response.searches.forEach {
            val entity = ItemDataFactory.makeItemEntity()
            entities.add(entity)
            stubClientResponseModelMapperMapFromModel(it, entity)
        }
        val testObserver = remote.findItemByText(param).test()
        testObserver.assertValue(entities)
    }

    private fun stubClientRestApiClients(singleObservable: Single<RemoteSearch>?, param: String?) {
        whenever(restApi.getItem(param)).thenReturn(singleObservable)
    }

    private fun stubClientResponseModelMapperMapFromModel(remote: RemoteItem,
                                                          entity: ItemEntity
    ) {
        whenever(mapper.mapFromRemote(remote)).thenReturn(entity)
    }

}
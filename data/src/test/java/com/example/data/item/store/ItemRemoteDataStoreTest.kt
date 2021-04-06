package com.example.data.item.store

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import com.segtechcu.data.test.factory.DataFactory
import com.example.data.item.model.ItemEntity
import com.example.data.item.repository.ItemRemote
import com.example.data.test.factory.ItemFactory
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ItemRemoteDataStoreTest {

    private val remote = mock<ItemRemote>()
    private val store = ItemRemoteDataStore(remote)

    @Test
    fun findMoviesByTextCompletes() {
        val param = DataFactory.randomString()
        stubRemoteFindItemByText(Single.just(listOf(ItemFactory.makeItemEntity())), param)
        val testObserver = store.findItemByText(param).test()
        testObserver.assertComplete()
    }

    @Test
    fun findMoviesByTextReturnsData() {
        val param = DataFactory.randomString()
        val data = listOf(ItemFactory.makeItemEntity())
        stubRemoteFindItemByText(Single.just(data), param)
        val testObserver = store.findItemByText(param).test()
        testObserver.assertValue(data)
    }

    private fun stubRemoteFindItemByText(singleObservable: Single<List<ItemEntity>>, param: String?) {
        whenever(remote.findItemByText(param)).thenReturn(singleObservable)
    }

}
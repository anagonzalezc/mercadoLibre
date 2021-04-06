package com.example.domain.item

import com.nhaarman.mockito_kotlin.whenever
import com.example.domain.executor.PostExecutionThread
import com.example.domain.item.model.Item
import com.example.domain.test.ItemDataFactory
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FindItemsUseCaseTest {

    private lateinit var findItemUseCase: FindItemUseCase
    @Mock lateinit var itemRepository: ItemRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        findItemUseCase = FindItemUseCase(itemRepository, postExecutionThread)
    }

    @Test
    fun findItemsUseCaseComplete() {
        val param = ItemDataFactory.randomUuid()
        stubFindItemUseCase(Single.just(ItemDataFactory.makeItemList(2)), param)
        val testObserver = findItemUseCase.buildUseCaseObservable(FindItemUseCase.Params(param)).test()
        testObserver.assertComplete()
    }

    @Test
    fun findItemsUseCaseReturnsData() {
        val param = ItemDataFactory.randomUuid()
        val items = ItemDataFactory.makeItemList(2)
        stubFindItemUseCase(Single.just(items), param)
        val testObserver = findItemUseCase.buildUseCaseObservable(FindItemUseCase.Params(param)).test()
        testObserver.assertValue(items)
    }

    private fun stubFindItemUseCase(singleObservable: Single<List<Item>>, param: String?) {
        whenever(itemRepository.findItemByText(param)).thenReturn(singleObservable)
    }

}
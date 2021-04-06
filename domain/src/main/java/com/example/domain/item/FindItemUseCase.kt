package com.example.domain.item

import com.example.domain.SingleUseCase
import com.example.domain.executor.PostExecutionThread
import com.example.domain.item.model.Item
import io.reactivex.Single
import javax.inject.Inject

open class FindItemUseCase @Inject constructor(
    private val itemRepository: ItemRepository,
    postExecutionThread: PostExecutionThread
) : SingleUseCase<List<Item>, FindItemUseCase.Params>(postExecutionThread) {

    public override fun buildUseCaseObservable(params: Params?): Single<List<Item>> {
        return itemRepository.findItemByText(params?.text)
    }

    data class Params(val text: String?)

}
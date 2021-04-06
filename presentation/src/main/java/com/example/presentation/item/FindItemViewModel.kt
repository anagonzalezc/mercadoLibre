package com.example.presentation.item

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.item.FindItemUseCase
import com.example.domain.item.model.Item
import com.example.presentation.Resource
import com.example.presentation.ResourceState
import com.example.presentation.item.model.ItemPresentation
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class FindItemViewModel @Inject constructor(
    private val findItemUseCase: FindItemUseCase,
    private val mapper: ItemPresentationMapper
)
    : ViewModel() {

    private val liveData: MutableLiveData<Resource<List<ItemPresentation>>> = MutableLiveData()

    override fun onCleared() {
        findItemUseCase.dispose()
        super.onCleared()
    }

    fun getItemLiveData(): LiveData<Resource<List<ItemPresentation>>> {
        return liveData
    }

    fun findItemByText(text: String?) {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        findItemUseCase.execute(ItemSubscriber(), FindItemUseCase.Params(text))
    }

    inner class ItemSubscriber: DisposableSingleObserver<List<Item>>() {
        override fun onSuccess(t: List<Item>) {
            liveData.postValue(Resource(
                    ResourceState.SUCCESS, t.map { mapper.mapToPresentation(it) }, null
            ))
        }

        override fun onError(e: Throwable) {
            liveData.postValue(Resource(ResourceState.ERROR, null, e.localizedMessage))
        }

    }

}
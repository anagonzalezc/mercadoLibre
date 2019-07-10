package com.example.presentation.music

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.music.FindMusicUseCase
import com.example.domain.music.model.Music
import com.example.presentation.Resource
import com.example.presentation.ResourceState
import com.example.presentation.music.model.MusicPresentation
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class FindMusicViewModel @Inject constructor(
    private val findMusicUseCase: FindMusicUseCase,
    private val mapper: MusicPresentationMapper)
    : ViewModel() {

    private val liveData: MutableLiveData<Resource<List<MusicPresentation>>> = MutableLiveData()

    override fun onCleared() {
        findMusicUseCase.dispose()
        super.onCleared()
    }

    fun getMusicLiveData(): LiveData<Resource<List<MusicPresentation>>> {
        return liveData
    }

    fun findMusicByText(text: String?) {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        findMusicUseCase.execute(MusicSubscriber(), FindMusicUseCase.Params(text))
    }

    inner class MusicSubscriber: DisposableSingleObserver<List<Music>>() {
        override fun onSuccess(t: List<Music>) {
            liveData.postValue(Resource(
                    ResourceState.SUCCESS, t.map { mapper.mapToPresentation(it) }, null
            ))
        }

        override fun onError(e: Throwable) {
            liveData.postValue(Resource(ResourceState.ERROR, null, e.localizedMessage))
        }

    }

}
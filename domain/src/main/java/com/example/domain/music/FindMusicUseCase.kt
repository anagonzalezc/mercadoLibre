package com.example.domain.music

import com.example.domain.SingleUseCase
import com.example.domain.executor.PostExecutionThread
import com.example.domain.music.model.Music
import io.reactivex.Single
import javax.inject.Inject

open class FindMusicUseCase @Inject constructor(
    private val musicRepository: MusicRepository,
    postExecutionThread: PostExecutionThread)
    : SingleUseCase<List<Music>, FindMusicUseCase.Params>(postExecutionThread) {

    public override fun buildUseCaseObservable(params: Params?): Single<List<Music>> {
        return musicRepository.findMusicByText(params?.text)
    }

    data class Params(val text: String?)

}
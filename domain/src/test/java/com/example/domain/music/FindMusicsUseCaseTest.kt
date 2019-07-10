package com.example.domain.music

import com.nhaarman.mockito_kotlin.whenever
import com.example.domain.executor.PostExecutionThread
import com.example.domain.music.model.Music
import com.example.domain.test.MusicDataFactory
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FindMusicsUseCaseTest {

    private lateinit var findMusicUseCase: FindMusicUseCase
    @Mock lateinit var musicRepository: MusicRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        findMusicUseCase = FindMusicUseCase(musicRepository, postExecutionThread)
    }

    @Test
    fun findMusicsUseCaseComplete() {
        val param = MusicDataFactory.randomUuid()
        stubFindMusicUseCase(Single.just(MusicDataFactory.makeMusicList(2)), param)
        val testObserver = findMusicUseCase.buildUseCaseObservable(FindMusicUseCase.Params(param)).test()
        testObserver.assertComplete()
    }

    @Test
    fun findMusicsUseCaseReturnsData() {
        val param = MusicDataFactory.randomUuid()
        val musics = MusicDataFactory.makeMusicList(2)
        stubFindMusicUseCase(Single.just(musics), param)
        val testObserver = findMusicUseCase.buildUseCaseObservable(FindMusicUseCase.Params(param)).test()
        testObserver.assertValue(musics)
    }

    private fun stubFindMusicUseCase(singleObservable: Single<List<Music>>, param: String?) {
        whenever(musicRepository.findMusicByText(param)).thenReturn(singleObservable)
    }

}
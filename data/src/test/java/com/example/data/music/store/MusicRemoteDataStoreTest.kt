package com.example.data.music.store

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import com.segtechcu.data.test.factory.DataFactory
import com.example.data.music.model.MusicEntity
import com.example.data.music.repository.MusicRemote
import com.example.data.test.factory.MusicFactory
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MusicRemoteDataStoreTest {

    private val remote = mock<MusicRemote>()
    private val store = MusicRemoteDataStore(remote)

    @Test
    fun findMoviesByTextCompletes() {
        val param = DataFactory.randomString()
        stubRemoteFindMoviesByText(Single.just(listOf(MusicFactory.makeMusicEntity())), param)
        val testObserver = store.findMusicByText(param).test()
        testObserver.assertComplete()
    }

    @Test
    fun findMoviesByTextReturnsData() {
        val param = DataFactory.randomString()
        val data = listOf(MusicFactory.makeMusicEntity())
        stubRemoteFindMoviesByText(Single.just(data), param)
        val testObserver = store.findMusicByText(param).test()
        testObserver.assertValue(data)
    }

    private fun stubRemoteFindMoviesByText(singleObservable: Single<List<MusicEntity>>, param: String?) {
        whenever(remote.findMusicByText(param)).thenReturn(singleObservable)
    }

}
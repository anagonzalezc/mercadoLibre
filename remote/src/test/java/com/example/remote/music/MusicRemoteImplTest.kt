package com.example.remote.music

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.example.data.music.model.MusicEntity
import com.example.remote.music.model.RemoteMusic
import com.example.remote.music.model.RemoteSearch
import com.example.remote.test.factory.DataFactory
import com.example.remote.test.factory.MusicDataFactory
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MusicRemoteImplTest {

    private val mapper = mock<MusicRemoteMapper>()
    private val restApi = mock<MusicRestApi>()
    private val remote = MusicRemoteImpl(restApi, mapper)


    @Test
    fun getClientCompletes() {
        val param = DataFactory.randomUuid()
        stubClientRestApiClients(Single.just(MusicDataFactory.makeMusicResponse()), param)
        stubClientResponseModelMapperMapFromModel(any(), MusicDataFactory.makeMusicEntity())

        val testObserver = remote.findMusicByText(param).test()
        testObserver.assertComplete()
    }

    @Test
    fun getClientCallsServer() {
        val param = DataFactory.randomUuid()
        stubClientRestApiClients(Single.just(MusicDataFactory.makeMusicResponse()), param)
        stubClientResponseModelMapperMapFromModel(any(), MusicDataFactory.makeMusicEntity())

        remote.findMusicByText(param).test()
        verify(restApi).getMusic(param)
    }

    @Test
    fun getClientReturnsData() {
        val param = DataFactory.randomUuid()
        val response = MusicDataFactory.makeMusicResponse()
        stubClientRestApiClients(Single.just(response), param)
        val entities = mutableListOf<MusicEntity>()
        response.search.forEach {
            val entity = MusicDataFactory.makeMusicEntity()
            entities.add(entity)
            stubClientResponseModelMapperMapFromModel(it, entity)
        }
        val testObserver = remote.findMusicByText(param).test()
        testObserver.assertValue(entities)
    }

    private fun stubClientRestApiClients(singleObservable: Single<RemoteSearch>?, param: String?) {
        whenever(restApi.getMusic(param)).thenReturn(singleObservable)
    }

    private fun stubClientResponseModelMapperMapFromModel(remote: RemoteMusic,
                                                          entity: MusicEntity) {
        whenever(mapper.mapFromRemote(remote)).thenReturn(entity)
    }

}
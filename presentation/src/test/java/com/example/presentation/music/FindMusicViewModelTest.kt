package com.example.presentation.music

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockito_kotlin.*
import com.example.domain.music.FindMusicUseCase
import com.example.domain.music.model.Music
import com.example.presentation.ResourceState
import com.example.presentation.music.model.MusicPresentation
import com.example.presentation.test.factory.DataFactory
import com.example.presentation.test.factory.MusicFactory
import io.reactivex.observers.DisposableSingleObserver
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Captor

@RunWith(JUnit4::class)
class FindMusicViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    var findMusicsUseCase = mock<FindMusicUseCase>()
    var musicMapper = mock<MusicPresentationMapper>()
    var musicViewModel = FindMusicViewModel(findMusicsUseCase, musicMapper)

    @Captor
    val captor = argumentCaptor<DisposableSingleObserver<List<Music>>>()

    @Test
    fun fetchMusicExecutesUseCase() {
        val param = DataFactory.randomString()
        musicViewModel.findMusicByText(param)

        verify(findMusicsUseCase, times(1)).execute(any(), eq(FindMusicUseCase.Params(param)))
    }

    @Test
    fun fetchMusicReturnsSuccess() {
        val param = DataFactory.randomString()
        val musics = MusicFactory.makeMusicList(2)
        val musicViews = MusicFactory.makeMusicViewList(2)
        stubMusicMapperToView(musicViews[0], musics[0])
        stubMusicMapperToView(musicViews[1], musics[1])

        musicViewModel.findMusicByText(param)
        verify(findMusicsUseCase).execute(captor.capture(), eq(FindMusicUseCase.Params(param)))
        captor.firstValue.onSuccess(musics)
        assertEquals(ResourceState.SUCCESS, musicViewModel.getMusicLiveData().value?.status)
    }

    @Test
    fun fetchMusicReturnsData() {
        val param = DataFactory.randomString()
        val musics = MusicFactory.makeMusicList(2)
        val musicViews = MusicFactory.makeMusicViewList(2)
        stubMusicMapperToView(musicViews[0], musics[0])
        stubMusicMapperToView(musicViews[1], musics[1])

        musicViewModel.findMusicByText(param)
        verify(findMusicsUseCase).execute(captor.capture(), eq(FindMusicUseCase.Params(param)))
        captor.firstValue.onSuccess(musics)
        assertEquals(musicViews, musicViewModel.getMusicLiveData().value?.data)
    }



    private fun stubMusicMapperToView(musicView: MusicPresentation, music: Music) {
        whenever(musicMapper.mapToPresentation(music)).thenReturn(musicView)
    }


}
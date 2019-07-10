package com.example.itunesmusic.music.displayMusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.itunesmusic.R
import com.example.itunesmusic.databinding.ActivityDisplayMusicBinding
import com.example.itunesmusic.di.ViewModelFactory
import com.example.itunesmusic.music.MusicViewMapper
import com.example.itunesmusic.music.model.MusicView
import com.example.presentation.Resource
import com.example.presentation.ResourceState
import com.example.presentation.music.FindMusicViewModel
import com.example.presentation.music.model.MusicPresentation
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

class DisplayMusicActivity : AppCompatActivity() {

    @Inject lateinit var displayMusicAdapter: DisplayMusicAdapter
    @Inject lateinit var mapper: MusicViewMapper
    @Inject lateinit var viewModelFactory: ViewModelFactory
    lateinit var findMusicViewModel: FindMusicViewModel
    private lateinit var binding: ActivityDisplayMusicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_display_music)
        AndroidInjection.inject(this)
        setUpView()
    }

    private fun setUpView() {
        setUpViewModelProvider()
        setUpRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.find_music_menu, menu)
        val searchView = menu?.findItem(R.id.menu_search)?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(text: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(text: String?): Boolean {
                findMoviesByText(text)
                return false
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_search -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setUpViewModelProvider() {
        findMusicViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(FindMusicViewModel::class.java)
    }

    private fun setUpRecyclerView() {
        try {
            binding.rvDisplayMusic.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
            binding.rvDisplayMusic.itemAnimator = DefaultItemAnimator()
            binding.rvDisplayMusic.adapter = displayMusicAdapter
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun findMoviesByText(text: String?) {
        findMusicViewModel.getMusicLiveData().observe(this,
                Observer<Resource<List<MusicPresentation>>> {
                    it?.let {
                        handleDataState(it)
                    }
                })
        findMusicViewModel.findMusicByText(text)
    }

    private fun handleDataState(resource: Resource<List<MusicPresentation>>) {
        when (resource.status) {
            ResourceState.SUCCESS -> {
                setScreenForSuccess(resource.data?.map {
                    mapper.mapToView(it)
                })
            }
            ResourceState.LOADING -> {
                binding.pbDisplayMusic.visibility = View.VISIBLE
                binding.gMakeSearch.visibility = View.GONE
            }
            ResourceState.ERROR -> {
                binding.pbDisplayMusic.visibility = View.GONE
                binding.gMakeSearch.visibility = View.VISIBLE
                binding.rvDisplayMusic.visibility = View.GONE
            }
        }
    }

    fun setScreenForSuccess(clients: List<MusicView>?) {
        binding.pbDisplayMusic.visibility = View.GONE
        clients?.let {
            displayMusicAdapter.setData(it)
            binding.gMakeSearch.visibility = View.GONE
            binding.rvDisplayMusic.visibility = View.VISIBLE
        } ?: run {
            Timber.d("setScreenForSuccess empty list")
            binding.gMakeSearch.visibility = View.VISIBLE
        }
    }



}

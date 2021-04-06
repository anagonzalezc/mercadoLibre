package com.example.mercado.item.displayItem

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
import com.example.mercado.R
import com.example.mercado.databinding.ActivityDisplayItemBinding
import com.example.mercado.di.ViewModelFactory
import com.example.mercado.item.ItemViewMapper
import com.example.mercado.item.model.ItemView
import com.example.presentation.Resource
import com.example.presentation.ResourceState
import com.example.presentation.item.FindItemViewModel
import com.example.presentation.item.model.ItemPresentation
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

class DisplayItemActivity : AppCompatActivity() {

    @Inject
    lateinit var displayItemAdapter: DisplayItemAdapter
    @Inject
    lateinit var mapper: ItemViewMapper
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var findItemViewModel: FindItemViewModel
    private lateinit var binding: ActivityDisplayItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_display_item)
        AndroidInjection.inject(this)
        setUpView()
    }

    private fun setUpView() {
        setUpViewModelProvider()
        setUpRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.find_item_menu, menu)
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
        findItemViewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(FindItemViewModel::class.java)
    }

    private fun setUpRecyclerView() {
        try {
            binding.rvDisplayItem.addItemDecoration(
                DividerItemDecoration(
                    this,
                    LinearLayoutManager.VERTICAL
                )
            )
            binding.rvDisplayItem.itemAnimator = DefaultItemAnimator()
            binding.rvDisplayItem.adapter = displayItemAdapter
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun findMoviesByText(text: String?) {
        findItemViewModel.getItemLiveData().observe(this,
            Observer<Resource<List<ItemPresentation>>> {
                it?.let {
                    handleDataState(it)
                }
            })
        findItemViewModel.findItemByText(text)
    }

    private fun handleDataState(resource: Resource<List<ItemPresentation>>) {
        when (resource.status) {
            ResourceState.SUCCESS -> {
                setScreenForSuccess(resource.data?.map {
                    mapper.mapToView(it)
                })
            }
            ResourceState.LOADING -> {
                binding.pbDisplayItem.visibility = View.VISIBLE
                binding.gMakeSearch.visibility = View.GONE
            }
            ResourceState.ERROR -> {
                binding.pbDisplayItem.visibility = View.GONE
                binding.gMakeSearch.visibility = View.VISIBLE
                binding.rvDisplayItem.visibility = View.GONE
            }
        }
    }

    fun setScreenForSuccess(clients: List<ItemView>?) {
        binding.pbDisplayItem.visibility = View.GONE
        clients?.let {
            displayItemAdapter.setData(it)
            binding.gMakeSearch.visibility = View.GONE
            binding.rvDisplayItem.visibility = View.VISIBLE
        } ?: run {
            Timber.d("setScreenForSuccess empty list")
            binding.gMakeSearch.visibility = View.VISIBLE
        }
    }

}

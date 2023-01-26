package com.example.rickandmorty.ui.list.locations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.rickandmorty.databinding.ActivityListLocationBinding
import com.example.rickandmorty.domain.Location
import com.example.rickandmorty.ui.detail.location.LocationDetailActivity
import kotlinx.coroutines.launch

class ListLocationActivity : AppCompatActivity() {
    lateinit var binding: ActivityListLocationBinding
    private var item: MutableList<Location> = mutableListOf()

    private val viewModel by viewModels<ListLocationViewModel>{ ListLocationViewModel.Factory.build() }

    private val listLocationAdapter: ListLocationAdapter by lazy {
        ListLocationAdapter().apply {
            onClick = this@ListLocationActivity::onItemSelected
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
    }


    private fun setup() {
        binding.apply {
            listItem.adapter = listLocationAdapter

            setSupportActionBar(listToolBar)
            supportActionBar?.setDisplayShowHomeEnabled(true)

            createLocationData()
        }
    }

    private fun onItemSelected(item:Location){
        intent = Intent(this, LocationDetailActivity::class.java)
        intent.putExtra(LocationDetailActivity.LOCATION_ID, item.id)
        startActivity(intent)
    }

    private fun createLocationData() {
        lifecycleScope.launch {
            viewModel.getLocations()
                .let (listLocationAdapter::addItems)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

}
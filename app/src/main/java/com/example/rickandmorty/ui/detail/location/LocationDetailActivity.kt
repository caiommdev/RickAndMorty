package com.example.rickandmorty.ui.detail.location

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.rickandmorty.databinding.ActivityLocationDetailBinding
import com.example.rickandmorty.domain.Location
import com.example.rickandmorty.ui.detail.location.LocationDetailViewModel
import kotlinx.coroutines.launch

class LocationDetailActivity : AppCompatActivity() {
    private val location_id by lazy{
        intent?.extras?.getInt(LOCATION_ID)
    }

    private val viewModel by viewModels<LocationDetailViewModel> { LocationDetailViewModel.Factory.build() }

    lateinit var binding: ActivityLocationDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocationDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.detailsToolBar)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        setup()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setup() {
        location_id?.let {id ->
            lifecycleScope.launch {
                val location = viewModel.getLocation(id)

                location?.let {
                    val item = it as? Location
                    binding.apply {
                        nameLocation.text = item?.name.orEmpty()
                        idLocation.text = item?.id.toString()
                        type.text = item?.type?.orEmpty()
                        dimension.text = item?.dimension?.orEmpty()
                    }
                }
            }
        }
    }

    companion object {
        const val LOCATION_ID = "location_id"
    }
}
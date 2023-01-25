package com.example.rickandmorty.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.rickandmorty.databinding.ActivityCharacterDetailBinding
import com.example.rickandmorty.domain.Character
import kotlinx.coroutines.launch

class CharacterDetailActivity : AppCompatActivity() {
    private val character_id by lazy{
        intent?.extras?.getInt(CHARACTER_ID)
    }

    private val viewModel by viewModels<DetailViewModel> { DetailViewModel.Factory.build() }

    lateinit var binding: ActivityCharacterDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
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
        character_id?.let {id ->
            lifecycleScope.launch {
                val character = viewModel.getCharacter(id)

                character?.let {
                    val item = it as? Character
                    binding.apply {
                        nameCharacter.text = item?.name.orEmpty()
                        race.text = item?.species.orEmpty()
                        status.text = item?.status?.name.orEmpty()
                        origin.text = item?.origin?.name.orEmpty()
                    }
                }
            }
        }
    }

    companion object {
        const val CHARACTER_ID = "character_id"
    }
}
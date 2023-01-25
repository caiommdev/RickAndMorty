package com.example.rickandmorty.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.rickandmorty.databinding.ActivityCharacterDetailBinding

class CharacterDetailActivity : AppCompatActivity() {
    private val character by lazy{
        intent?.extras?.getSerializable(CHARACTER)
    }

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
        character?.let {
            val item = it as? Character
            binding.apply {
                nameCharacter.text = item?.title.orEmpty()
                race.text = item?.description.orEmpty()
                status.text = item?.status.orEmpty()
                origin.text = item?.origin.orEmpty()
            }
        }
    }

    companion object {
        const val CHARACTER = "character"
    }
}
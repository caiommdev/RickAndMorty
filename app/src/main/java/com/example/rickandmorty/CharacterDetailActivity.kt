package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rickandmorty.databinding.ActivityCharacterDetailBinding

class CharacterDetailActivity : AppCompatActivity() {
    val character by lazy{
        intent?.extras?.getSerializable(CHARACTER)
    }

    lateinit var binding: ActivityCharacterDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        const val CHARACTER = "character"
    }
}
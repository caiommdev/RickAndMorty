package com.example.rickandmorty.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.rickandmorty.R
import com.example.rickandmorty.data.CharacterService
import com.example.rickandmorty.databinding.ActivityMenuBinding
import kotlinx.coroutines.launch

class MenuActivity : AppCompatActivity() {

    private val service by lazy {
        CharacterService()
    }

    lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setup()

        lifecycleScope.launch {
            service.getAllCharacters()
                .forEach {  println(it) }
        }
    }

    private fun setup() {
        val intent = Intent(this, ListCharacterActivity::class.java)
        binding.apply {
            menuButtonCharacters.setOnClickListener {
                startActivity(intent)
            }

            menuButtonPlace.setOnClickListener {
                startActivity(intent)
            }

            setSupportActionBar(menuToolBar)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        }
    }
}
package com.example.rickandmorty.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.rickandmorty.R
import com.example.rickandmorty.data.CharacterService
import com.example.rickandmorty.databinding.ActivityMenuBinding
import com.example.rickandmorty.ui.list.ListCharacterActivity
import com.example.rickandmorty.ui.list.ListLocationActivity
import kotlinx.coroutines.launch

class MenuActivity : AppCompatActivity() {

    lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setup()
    }

    private fun setup() {
        //val intent = Intent(this, ListCharacterActivity::class.java)
        binding.apply {
            menuButtonCharacters.setOnClickListener {
                val intent = Intent(this@MenuActivity, ListCharacterActivity::class.java)
                startActivity(intent)
            }

            menuButtonPlace.setOnClickListener {
                val intent = Intent(this@MenuActivity, ListLocationActivity::class.java)
                startActivity(intent)
            }

            setSupportActionBar(menuToolBar)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        }
    }
}
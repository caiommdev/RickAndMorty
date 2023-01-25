package com.example.rickandmorty.ui.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.rickandmorty.databinding.ActivityListCharacterBinding
import com.example.rickandmorty.ui.detail.CharacterDetailActivity
import com.example.rickandmorty.domain.Character
import kotlinx.coroutines.launch

class ListCharacterActivity : AppCompatActivity() {

    lateinit var binding: ActivityListCharacterBinding
    private var item: MutableList<Character> = mutableListOf()

    private val viewModel by viewModels<ListViewModel>{ ListViewModel.Factory.build() }

    private val listAdapter: ListAdapter by lazy {
        ListAdapter().apply {
            onClick = this@ListCharacterActivity::onItemSelected
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
    }


    private fun setup() {
        binding.apply {
            listItem.adapter = listAdapter

            setSupportActionBar(listToolBar)
            supportActionBar?.setDisplayShowHomeEnabled(true)

            createCharacterData()
        }
    }

    private fun onItemSelected(item: Character){
        intent = Intent(this, CharacterDetailActivity::class.java)
        intent.putExtra(CharacterDetailActivity.CHARACTER_ID, item.id)
        startActivity(intent)
    }

    private fun createCharacterData() {
        lifecycleScope.launch {
            viewModel.getCharacters()
                .let (listAdapter::addItems)
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
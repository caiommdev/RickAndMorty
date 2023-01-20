package com.example.rickandmorty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rickandmorty.databinding.ActivityListCharacterBinding

class ListCharacterActivity : AppCompatActivity() {

    lateinit var binding: ActivityListCharacterBinding
    private var item: MutableList<Character> = mutableListOf()

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
        }
        createData()
    }

    private fun createData(){
        item.add(Character(id = "1", title = "Rick", description = "Humano"))
        item.add(Character(id = "2", title = "Morty", description = "Humano"))
        item.add(Character(id = "3", title = "Armothy", description = "Desconhecido"))
        item.add(Character(id = "4", title = "Mr.Sneezy", description = "Humano"))

        listAdapter.addItems(item)
    }

    private fun onItemSelected(item: Character){
        intent = Intent(this, CharacterDetailActivity::class.java)
        intent.putExtra(CharacterDetailActivity.CHARACTER, item)
        startActivity(intent)
    }
}
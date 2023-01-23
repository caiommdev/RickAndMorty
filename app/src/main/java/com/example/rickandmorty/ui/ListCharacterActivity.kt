package com.example.rickandmorty.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
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

            setSupportActionBar(listToolBar)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        }
        createData()
    }

    private fun onItemSelected(item: Character){
        intent = Intent(this, CharacterDetailActivity::class.java)
        intent.putExtra(CharacterDetailActivity.CHARACTER, item)
        startActivity(intent)
    }

    private fun createData(){
        item.add(
            Character(
                id = "1",
                title = "Rick",
                description = "Humano",
                status = "Vivo",
                origin = "Earth"
            )
        )
        item.add(
            Character(
                id = "2",
                title = "Morty",
                description = "Humano",
                status = "Vivo",
                origin = "Earth"
            )
        )
        item.add(
            Character(
                id = "3",
                title = "Armothy",
                description = "Desconhecido",
                status = "Vivo",
                origin = "Post-Apocalyptic Earth"
            )
        )
        item.add(
            Character(
                id = "4",
                title = "Mr.Sneezy",
                description = "Humano",
                status = "morto",
                origin = "Earth"
            )
        )

        listAdapter.addItems(item)
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
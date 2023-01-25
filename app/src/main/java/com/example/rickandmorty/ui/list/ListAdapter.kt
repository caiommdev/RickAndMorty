package com.example.rickandmorty.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ItemRowBinding
import com.example.rickandmorty.ui.CharacterUi


class ListAdapter:
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root)
    var onClick: ((CharacterUi) -> Unit)? = null


    private var items: MutableList<CharacterUi> = mutableListOf()
        set(value) {
            field = ArrayList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = ItemRowBinding.inflate(inflater, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(items.isEmpty())
            return

        holder.apply {
            val item = items[position]
            binding.title.text = item.title
            binding.description.text = item.description

            itemView.setOnClickListener {
                onClick?.invoke(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItems(charactersToAdd: List<CharacterUi>) {
        this.items.addAll(charactersToAdd)
        notifyDataSetChanged()
    }

    fun update(allCharacters: List<CharacterUi>) {
        this.items.clear()
        this.items.addAll(allCharacters)
        notifyDataSetChanged()
    }

}
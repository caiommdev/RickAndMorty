package com.example.rickandmorty.ui.list.locations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ItemRowBinding
import com.example.rickandmorty.domain.Location


class ListLocationAdapter:
    RecyclerView.Adapter<ListLocationAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root)
    var onClick: ((Location) -> Unit)? = null


    private var items: MutableList<Location> = mutableListOf()
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
            binding.title.text = item.name
            binding.description.text = item.type

            itemView.setOnClickListener {
                onClick?.invoke(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItems(charactersToAdd: List<Location>) {
        this.items.addAll(charactersToAdd)
        notifyDataSetChanged()
    }

    fun update(allLocations: List<Location>) {
        this.items.clear()
        this.items.addAll(allLocations)
        notifyDataSetChanged()
    }

}
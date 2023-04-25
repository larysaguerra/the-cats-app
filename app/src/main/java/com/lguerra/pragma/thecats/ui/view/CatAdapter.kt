package com.lguerra.pragma.thecats.ui.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lguerra.pragma.thecats.data.model.Cat
import com.lguerra.pragma.thecats.databinding.ItemCatBinding
import com.squareup.picasso.Picasso

class CatAdapter : ListAdapter<Cat, CatAdapter.CatViewHolder>(PermissionDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CatViewHolder(
            ItemCatBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
                .root
        )

    override fun onBindViewHolder(viewHolder: CatViewHolder, position: Int) {
        viewHolder.bind(getItem(position))
    }

    override fun getItemCount() = currentList.size

    class CatViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemCatBinding.bind(itemView)
        private lateinit var currentCat: Cat

        fun bind(cat: Cat) {
            currentCat = cat
            binding.textName.apply { text = currentCat.breedName }
            Picasso.get().load(currentCat.imageUrl).into(binding.imageCat)

            binding.imageCat.apply { setBackgroundColor(Color.BLACK) }
            binding.textOrigin.apply { text = currentCat.origin }
            binding.textIntelligence.apply { text = currentCat.intelligence.toString() }
        }

    }

}

object PermissionDiffCallback : DiffUtil.ItemCallback<Cat>() {
    override fun areItemsTheSame(oldItem: Cat, newItem: Cat) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Cat, newItem: Cat) =
        oldItem.breedName == newItem.breedName
}
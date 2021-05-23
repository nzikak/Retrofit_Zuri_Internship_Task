package com.android.zuritask.nsikak.rickandmorty.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.zuritask.nsikak.rickandmorty.R
import com.android.zuritask.nsikak.rickandmorty.databinding.ListItemBinding
import com.android.zuritask.nsikak.rickandmorty.models.Character
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class CharactersAdapter(private val characters: List<Character>) :
    RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }

    override fun getItemCount() = characters.size

    inner class CharacterViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(character: Character) {
            Glide.with(binding.imageView)
                .load(character.imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .error(R.drawable.ic_error)
                .into(binding.imageView)

            binding.apply {
                nameTextView.text = character.name
                speciesTextView.text = character.species
                statusTextView.text = character.status
            }
            changeTextColor(character.status, binding.statusTextView)
        }

        private fun changeTextColor(status: String, textView: TextView) {
            when (status) {
                "Alive" -> {
                    textView.setTextColor(Color.parseColor("#00FF00"))
                }
                "Dead" -> {
                    textView.setTextColor(Color.parseColor("#FF0000"))
                }
                else -> {
                    textView.setTextColor(Color.parseColor("#FFFFFF"))
                }
            }
        }
    }
}
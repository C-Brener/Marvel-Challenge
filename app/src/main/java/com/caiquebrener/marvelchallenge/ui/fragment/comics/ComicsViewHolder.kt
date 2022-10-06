package com.caiquebrener.marvelchallenge.ui.fragment.comics

import androidx.recyclerview.widget.RecyclerView
import com.caiquebrener.marvelchallenge.databinding.ComicCardItemBinding
import com.caiquebrener.marvelchallenge.ui.model.CharactersModel
import com.squareup.picasso.Picasso

class ComicsViewHolder(private val binding: ComicCardItemBinding):RecyclerView.ViewHolder(binding.root) {

    fun bindingRoot(comics:CharactersModel){
        binding.titleComic.text = comics.name
        insertImageUrl(comics)
    }

    private fun insertImageUrl(comics: CharactersModel) {
        Picasso.get()
            .load(comics.url)
            .into(binding.imageComic)
    }
}
package com.caiquebrener.marvelchallenge.ui.fragment.comics

import androidx.recyclerview.widget.RecyclerView
import com.caiquebrener.marvelchallenge.databinding.ComicCardItemBinding
import com.caiquebrener.marvelchallenge.ui.model.ComicsModel
import com.squareup.picasso.Picasso

class ComicsViewHolder(private val binding: ComicCardItemBinding):RecyclerView.ViewHolder(binding.root) {

    fun bindingRoot(comics:ComicsModel){
        binding.titleComic.text = comics.name
        insertImageUrl(comics)
    }

    private fun insertImageUrl(comics: ComicsModel) {
        Picasso.get()
            .load(comics.url)
            .into(binding.imageComic)
    }
}
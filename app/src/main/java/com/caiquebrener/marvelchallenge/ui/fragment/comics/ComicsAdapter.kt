package com.caiquebrener.marvelchallenge.ui.fragment.comics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.caiquebrener.marvelchallenge.databinding.ComicCardItemBinding
import com.caiquebrener.marvelchallenge.ui.model.ComicsModel

class ComicsAdapter(
    private val comicList: List<ComicsModel>,
    private val comicClick: (ComicsModel) -> Unit
) :
    RecyclerView.Adapter<ComicsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        return ComicsViewHolder(
            ComicCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        comicList?.let { listComic ->
            holder.bindingRoot(listComic[position])
            holder.itemView.setOnClickListener {
                comicClick(listComic[position])

            }
        }
    }

    override fun getItemCount() = comicList.size

}
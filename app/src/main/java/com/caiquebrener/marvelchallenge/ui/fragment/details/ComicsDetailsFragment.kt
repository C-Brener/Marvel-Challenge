package com.caiquebrener.marvelchallenge.ui.fragment.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.caiquebrener.marvelchallenge.databinding.FragmentComicsDetailsBinding
import com.caiquebrener.marvelchallenge.ui.model.ComicsModel
import com.caiquebrener.marvelchallenge.ui.viewmodel.SharedViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ComicsDetailsFragment : Fragment() {
    private var _binding: FragmentComicsDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SharedViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentComicsDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.comic.observe(viewLifecycleOwner){
            insertImageUrl(it)
        }

    }
    private fun insertImageUrl(comics: ComicsModel) {
        Picasso.get()
            .load(comics.url)
            .into(binding.comicImage)
    }

}
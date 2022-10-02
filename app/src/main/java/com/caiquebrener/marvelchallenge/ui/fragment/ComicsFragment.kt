package com.caiquebrener.marvelchallenge.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.caiquebrener.marvelchallenge.R
import com.caiquebrener.marvelchallenge.databinding.FragmentComicsBinding
import com.caiquebrener.marvelchallenge.ui.viewmodel.SharedViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ComicsFragment : Fragment() {
    private var _binding: FragmentComicsBinding? = null
    private val binding get() = _binding!!

    private val viewmodel: SharedViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentComicsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.getCharacters("Hulk")

        viewmodel.name.observe(viewLifecycleOwner) {
            binding.textViewComic.text = it
        }
        viewmodel.image.observe(viewLifecycleOwner) {
            it?.let { url ->
                if (url.isNotEmpty()) {
                    Picasso.get()
                        .load(url)
                        .error(R.drawable.ic_book_24)
                        .into(binding.ImageView)
                }
            }

        }

    }
}

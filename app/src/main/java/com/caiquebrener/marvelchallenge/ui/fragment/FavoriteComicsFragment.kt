package com.caiquebrener.marvelchallenge.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.caiquebrener.marvelchallenge.databinding.FragmentFavoriteComicsBinding
import com.caiquebrener.marvelchallenge.ui.viewmodel.SharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FavoriteComicsFragment : Fragment() {
    private var _binding: FragmentFavoriteComicsBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteComicsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.name.observe(viewLifecycleOwner) {
            binding.textView2.text = it
        }
    }
}
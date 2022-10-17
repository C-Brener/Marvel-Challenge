package com.caiquebrener.marvelchallenge.ui.fragment.comics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.caiquebrener.marvelchallenge.databinding.FragmentComicsBinding
import com.caiquebrener.marvelchallenge.ui.model.ComicsModel
import com.caiquebrener.marvelchallenge.ui.viewmodel.SharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ComicsFragment : Fragment() {
    private var _binding: FragmentComicsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SharedViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentComicsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.listComic.observe(viewLifecycleOwner) { list ->
            setupRecyclerView(list)
        }
    }

    private fun setupRecyclerView(list: List<ComicsModel>) {
        with(binding.recyclerComicsView) {
            adapter = ComicsAdapter(list) {
                viewModel.setComicsDetails(it)
                setNavigationComicsDetails()
            }
            layoutManager =
                GridLayoutManager(context, 2)
        }
    }

    private fun setNavigationComicsDetails() {
        findNavController().navigate(ComicsFragmentDirections.actionComicsFragmentToComicsDetailsFragment())
    }
}

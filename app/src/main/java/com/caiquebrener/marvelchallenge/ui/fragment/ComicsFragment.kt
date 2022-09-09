package com.caiquebrener.marvelchallenge.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.caiquebrener.marvelchallenge.R
import com.caiquebrener.marvelchallenge.ui.viewmodel.SharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ComicsFragment : Fragment() {
    private val viewmodel: SharedViewModel by viewModel<SharedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comics, container, false)
    }

}

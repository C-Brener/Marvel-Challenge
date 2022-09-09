package com.caiquebrener.marvelchallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.caiquebrener.marvelchallenge.databinding.ActivityMainBinding
import com.caiquebrener.marvelchallenge.ui.viewmodel.SharedViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: SharedViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.getCharacters("Iron Man")
        viewModel.name.observe(this) {
            binding.teste.text = it
        }

    }


}
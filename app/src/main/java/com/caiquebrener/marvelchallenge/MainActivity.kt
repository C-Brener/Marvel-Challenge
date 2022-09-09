package com.caiquebrener.marvelchallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.caiquebrener.marvelchallenge.databinding.ActivityMainBinding
import com.caiquebrener.marvelchallenge.ui.SharedViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val viewModel = SharedViewModel()
        viewModel.getCharacters()
        viewModel.name.observe(this) {
            binding.teste.text = it.toString()
        }
    }
}
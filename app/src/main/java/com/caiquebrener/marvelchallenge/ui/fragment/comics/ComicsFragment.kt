package com.caiquebrener.marvelchallenge.ui.fragment.comics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import coil.compose.rememberAsyncImagePainter
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
    ): View? {
        _binding = FragmentComicsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.jetpackCompose.setContent {
            MaterialTheme {
                comicView()
            }
        }
        viewModel.getComics()
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.name.observe(viewLifecycleOwner) { list ->
//            setupRecyclerView(list)
        }
    }

    @Composable
    private fun comicView() {
        val viewmodel: SharedViewModel = viewModel
        val messages by viewmodel.name.observeAsState()
        Greeting(message = messages)

    }

    @Preview
    @Composable
    private fun Preview() {
        Greeting(
            message =
            listOf(
                ComicsModel(
                    "Caique",
                    1,
                    "https://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada/portrait_xlarge.jpg",
                    ""
                )
            )
        )
    }

    @Composable
    private fun Greeting(message: List<ComicsModel>?) {
        LazyColumn() {
            item {
                message?.forEach {
                    CardComicView(message = it)

                }
            }
        }

    }

    @Composable
    private fun CardComicView(message: ComicsModel) {
        Card(
            modifier = Modifier
                .width(120.dp)
                .padding(5.dp)
                .fillMaxSize()
        ) {
            var expanded by remember{ mutableStateOf(false)}
            Column(Modifier.clickable { expanded = !expanded }) {
                Image(
                    painter = rememberAsyncImagePainter(model = message.url),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(128.dp)
                )
                AnimatedVisibility(visible = expanded) {
                    Text(
                        text = message.name!!,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
        }

    }
}


//
//    private fun setupRecyclerView(list: List<ComicsModel>) {
//        binding.recyclerComicsView.adapter = ComicsAdapter(list)
//        binding.recyclerComicsView.layoutManager =
//            GridLayoutManager(context, 2)
//    }


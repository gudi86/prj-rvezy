package com.rvery.presenter.catsgrid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rvery.R.layout
import com.rvery.databinding.GridCatsViewBinding
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GridCatsView : AppCompatActivity() {

    private lateinit var binding: GridCatsViewBinding

    val viewModel: GridCatsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.grid_cats_view)

        binding = GridCatsViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this

        binding.viewModel = viewModel
    }
}
package com.lguerra.pragma.thecats.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lguerra.pragma.thecats.databinding.ActivityMainBinding
import com.lguerra.pragma.thecats.ui.viewmodel.CatsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: CatsViewModel by viewModels()

    private val catAdapter = CatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpListAdapter()

        viewModel.onCreate()
        viewModel.cats.observe(this) {
            catAdapter.submitList(it)
        }

    }

    private fun setUpListAdapter() {
        binding.recyclerCats.apply {
            layoutManager = LinearLayoutManager(this@CatsActivity)
            adapter = catAdapter
        }
    }

}
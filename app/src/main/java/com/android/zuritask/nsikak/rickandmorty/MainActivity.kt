package com.android.zuritask.nsikak.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.android.zuritask.nsikak.rickandmorty.adapters.CharactersAdapter
import com.android.zuritask.nsikak.rickandmorty.api.Api
import com.android.zuritask.nsikak.rickandmorty.databinding.ActivityMainBinding
import com.android.zuritask.nsikak.rickandmorty.models.Character
import com.android.zuritask.nsikak.rickandmorty.repository.Repository
import com.android.zuritask.nsikak.rickandmorty.viewmodels.MainViewModel
import com.android.zuritask.nsikak.rickandmorty.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private val characters = mutableListOf<Character>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeViewModel()
        val adapter = CharactersAdapter(characters)

        mainViewModel.characters.observe(this) {
            characters.addAll(it)
            adapter.notifyDataSetChanged()
            binding.progressBar.isVisible = false
        }
        binding.charactersRecyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.charactersRecyclerView.adapter = adapter
    }

    private fun initializeViewModel() {
        val repository = Repository(Api.apiService)
        val mainViewModelFactory = MainViewModelFactory(repository)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory)
            .get(MainViewModel::class.java)
    }
}
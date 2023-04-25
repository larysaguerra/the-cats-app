package com.lguerra.pragma.thecats.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lguerra.pragma.thecats.data.CatsRepository
import com.lguerra.pragma.thecats.data.model.Cat
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject constructor(private val catsRepository: CatsRepository) : ViewModel() {

    val cats = MutableLiveData<List<Cat>>()

    fun onCreate() {
        viewModelScope.launch {
            val result = catsRepository.getCatsFromApi()

            cats.postValue(result)
        }
    }

}
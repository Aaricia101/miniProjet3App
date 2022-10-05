package ca.qc.cgodin.mini_projet3.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.qc.cgodin.mini_projet3.models.Succursale
import ca.qc.cgodin.mini_projet3.models.SucsResponse
import ca.qc.cgodin.mini_projet3.repository.SucRepository
import kotlinx.coroutines.launch

class SucViewModel(private val sucRepository: SucRepository) :  ViewModel(){
    val listSucs: MutableLiveData<SucsResponse> = MutableLiveData()

    init{
        getSuc()
    }

    private fun getSuc()= viewModelScope.launch{
        try {
            val response = sucRepository.getSuc()
            listSucs.postValue(response.body())
        }catch (e: Exception){

        }

    }
}
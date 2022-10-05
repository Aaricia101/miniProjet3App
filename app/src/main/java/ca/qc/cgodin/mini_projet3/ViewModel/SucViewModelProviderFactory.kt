package ca.qc.cgodin.mini_projet3.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import ca.qc.cgodin.mini_projet3.Adapter.sucAdapter
import ca.qc.cgodin.mini_projet3.models.Succursale
import ca.qc.cgodin.mini_projet3.repository.SucRepository
import kotlinx.coroutines.launch

class SucViewModelProviderFactory(private val sucRepository: SucRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(SucViewModel::class.java)){
            SucViewModel(sucRepository) as T
        }else{
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}

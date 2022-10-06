package ca.qc.cgodin.mini_projet3.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.qc.cgodin.mini_projet3.models.SuccursalesReponse
import ca.qc.cgodin.mini_projet3.repository.SucRepository
import kotlinx.coroutines.launch

class SucViewModel(private val sucRepository: SucRepository) :  ViewModel(){
    val listSucs: MutableLiveData<SuccursalesReponse> = MutableLiveData()

    init{
        getSuc("999999999999")
    }

    private fun getSuc(auth:String)= viewModelScope.launch{
        try {
            val response = sucRepository.getSuc(auth)
            listSucs.postValue(response.body())
            Log.i("test", listSucs.value.toString())
        }catch (e: Exception){

        }

    }
}
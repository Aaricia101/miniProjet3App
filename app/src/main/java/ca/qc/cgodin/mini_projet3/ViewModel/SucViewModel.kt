package ca.qc.cgodin.mini_projet3.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.qc.cgodin.mini_projet3.models.Succursales
import ca.qc.cgodin.mini_projet3.models.SuccursalesReponse
import ca.qc.cgodin.mini_projet3.repository.SucRepository
import kotlinx.coroutines.launch

class SucViewModel(private val sucRepository: SucRepository) :  ViewModel(){
    val listSucs: MutableLiveData<SuccursalesReponse> = MutableLiveData()
    private val repository:SucRepository = SucRepository()

    fun getSuc()= viewModelScope.launch{
        try {
            val response = sucRepository.getSuc()
            //Log.i("test", response.message())
            listSucs.postValue(response.body())

        }catch (e: Exception){
            Log.i("test", "wtf"+e.message.toString())
        }

    }

    suspend fun connectStudent(matricule: String, password: String): Boolean {

        return sucRepository.ConnectStudent(matricule, password)

    }

    fun addSuc(access:String, budget:String, ville:String) = viewModelScope.launch {
        repository.AddSuc(access, budget, ville)
    }

    fun deleteSuc(suc: String)= viewModelScope.launch {
        repository.Delete(suc)
    }

    fun UpdateSuc(suc: String)= viewModelScope.launch {
        repository.Update(suc)
    }

}
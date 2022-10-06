package ca.qc.cgodin.mini_projet3.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.qc.cgodin.mini_projet3.models.StudentsResponse
import ca.qc.cgodin.mini_projet3.models.SuccursalesReponse
import ca.qc.cgodin.mini_projet3.repository.SucRepository
import kotlinx.coroutines.launch

class SucViewModel(private val sucRepository: SucRepository) :  ViewModel(){
    val listSucs: MutableLiveData<SuccursalesReponse> = MutableLiveData()

    init{

    }

    fun getSuc(auth:String)= viewModelScope.launch{
        try {
            val response = sucRepository.getSuc(auth)
            //Log.i("test", response.message())
            listSucs.postValue(response.body())

        }catch (e: Exception){
            Log.i("test", e.message.toString())
        }

    }

    suspend fun connectStudent(matricule: String, password: String): StudentsResponse {

        return sucRepository.ConnectStudent(matricule, password)

    }
}
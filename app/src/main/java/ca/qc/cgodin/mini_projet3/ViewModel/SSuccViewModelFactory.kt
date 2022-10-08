package ca.qc.cgodin.mini_projet3.ViewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SSuccViewModelFactory(private val application: Application) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(SSuccViewModel::class.java)){
            SSuccViewModel(application) as T
        }else{
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }


}
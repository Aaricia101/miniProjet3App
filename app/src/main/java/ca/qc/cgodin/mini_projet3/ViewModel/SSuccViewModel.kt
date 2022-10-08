package ca.qc.cgodin.mini_projet3.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import ca.qc.cgodin.mini_projet3.Room.SSuccRoomDatabase
import ca.qc.cgodin.mini_projet3.Room.SavedSuccs
import ca.qc.cgodin.mini_projet3.repository.SavedSucRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SSuccViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: SavedSucRepository

    val allSuccs: LiveData<List<SavedSuccs>>
    var filteredSuccs: LiveData<List<SavedSuccs>>

    init{
        val succDao = SSuccRoomDatabase.getDatabase(application).succDao()
        repository = SavedSucRepository(succDao)
        allSuccs = repository.allSuccs
        filteredSuccs = allSuccs
    }

    fun insertSSucc(succ: SavedSuccs) = viewModelScope.launch(Dispatchers.IO){
        repository.insertSSucc(succ)
    }

    fun updateSSucc(succ: SavedSuccs) = viewModelScope.launch(Dispatchers.IO){
        repository.updateSSucc(succ)
    }

    fun deleteSSucc(succ: SavedSuccs) = viewModelScope.launch(Dispatchers.IO){
        repository.deleteSSucc(succ)
    }

    fun searchSSucc(ville: String) = viewModelScope.launch(Dispatchers.IO){
        filteredSuccs = repository.searchSSucc(ville)
    }
}
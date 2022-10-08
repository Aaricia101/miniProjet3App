package ca.qc.cgodin.mini_projet3.repository

import androidx.lifecycle.LiveData
import ca.qc.cgodin.mini_projet3.Room.SavedSuccs
import ca.qc.cgodin.mini_projet3.Room.SuccDao

class SavedSucRepository(private val succDao:SuccDao) {
    val allSuccs : LiveData<List<SavedSuccs>> = succDao.getSSuccs()

    fun insertSSucc(succ: SavedSuccs){
        succDao.insertSSucc(succ)
    }

    fun updateSSucc(succ: SavedSuccs){
        succDao.updateSSucc(succ)
    }

    fun deleteSSucc(succ: SavedSuccs){
        succDao.deleteSSucc(succ)
    }

    fun searchSSucc(ville:String) : LiveData<List<SavedSuccs>>{
        return succDao.searchSSucc(ville)
    }

}
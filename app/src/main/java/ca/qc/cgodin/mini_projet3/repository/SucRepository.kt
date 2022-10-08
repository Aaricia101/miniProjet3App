package ca.qc.cgodin.mini_projet3.repository

import ca.qc.cgodin.mini_projet3.models.Succursales
import ca.qc.cgodin.mini_projet3.network.RetrofitInstance

class SucRepository() {

    suspend fun getSuc() = RetrofitInstance.retrofitService.getSuc()

    suspend fun ConnectStudent(matricule:String, password:String): Boolean {
        return RetrofitInstance.retrofitService.connectStudent(matricule, password)

    }

    suspend fun AddSuc(access:String, budget:String, ville:String) = RetrofitInstance.retrofitService.addSuc(access, budget, ville)

    suspend fun Delete(suc:String)= RetrofitInstance.retrofitService.deleteSuc(suc)

    suspend fun Update(suc:String)= RetrofitInstance.retrofitService.UpdateSuc(suc)

}
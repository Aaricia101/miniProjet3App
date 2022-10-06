package ca.qc.cgodin.mini_projet3.repository

import ca.qc.cgodin.mini_projet3.network.RetrofitInstance

class SucRepository() {

    suspend fun getSuc(auth:String) = RetrofitInstance.retrofitService.getSuc(auth)
}
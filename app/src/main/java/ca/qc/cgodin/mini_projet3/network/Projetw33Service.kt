package ca.qc.cgodin.mini_projet3.network

import androidx.lifecycle.LiveData
import ca.qc.cgodin.mini_projet3.models.Student
import ca.qc.cgodin.mini_projet3.models.Succursale
import ca.qc.cgodin.mini_projet3.models.SucsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Projetw33Service{
    @GET("/succursales/Succursale-Liste")
    fun getSuc(): Response<SucsResponse>
}
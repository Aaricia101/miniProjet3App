package ca.qc.cgodin.mini_projet3.network

import retrofit2.Response
import retrofit2.http.GET

interface Projetw33Service{
    @GET("/succursales/Succursale-Liste")
    fun getSuc(): Response<SucsResponse>
}
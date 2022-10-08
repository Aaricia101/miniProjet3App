package ca.qc.cgodin.mini_projet3.network

import ca.qc.cgodin.mini_projet3.models.*
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Projetw33Service{
    @GET("/succursales/Succursale-Liste")
    suspend fun getSuc(
    ): Response<SuccursalesReponse>

    @GET("/students/Connexion")
    suspend fun connectStudent(
        @Query("matricule")
        matricule:String,
        @Query("password")
        password:String
    ):Boolean

    @POST("/succursales/Succursale-Ajout")
    suspend fun addSuc(
        @Query("access")
        access: String,
        @Query("budget")
        budget: String,
        @Query("ville")
        ville:String
    )

    @DELETE("/succursales/Succursale-Retrait")
    suspend fun deleteSuc(
        @Query("succursale")
        succursale: String
    )

    @POST("/succursales/update-Succursale")
    suspend fun UpdateSuc(
        @Query("succursale")
        succursale: String
    )
}
package ca.qc.cgodin.mini_projet3.network

import ca.qc.cgodin.mini_projet3.models.Student
import ca.qc.cgodin.mini_projet3.models.StudentsResponse
import ca.qc.cgodin.mini_projet3.models.SuccursalesReponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Projetw33Service{
    @GET("/succursales/Succursale-Liste")
    suspend fun getSuc(
        @Query("Aut")
        auth: String = "999999999999"
    ): Response<SuccursalesReponse>

    @GET("/students/Connexion")
    suspend fun connectStudent(
        @Query("matricule")
        matricule:String,
        @Query("password")
        password:String
    ):StudentsResponse
}
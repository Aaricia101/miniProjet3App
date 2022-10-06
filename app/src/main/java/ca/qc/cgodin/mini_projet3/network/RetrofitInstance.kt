package ca.qc.cgodin.mini_projet3.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://10.0.2.2:3000"
class RetrofitInstance {

    companion object{
        private val retrofitInstance by lazy {
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        }

        val retrofitService by lazy {
            retrofitInstance.create(Projetw33Service::class.java)
        }
    }

}
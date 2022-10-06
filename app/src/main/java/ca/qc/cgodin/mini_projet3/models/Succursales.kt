package ca.qc.cgodin.mini_projet3.models


import com.google.gson.annotations.SerializedName

data class Succursales(
    @SerializedName("AccesMdP")
    val accesMdP: String,
    @SerializedName("Budget")
    val budget: String,
    @SerializedName("Ville")
    val ville: String
)
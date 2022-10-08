package ca.qc.cgodin.mini_projet3.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable
import kotlinx.serialization.*
data class Succursales(
    @SerializedName("AccesMdP")
    val accesMdP: String,
    @SerializedName("Ville")
    val ville: String,
    @SerializedName("Budget")
    val budget: String
) : Serializable
package ca.qc.cgodin.mini_projet3.models

import com.google.gson.annotations.SerializedName


data class SuccursalesReponse (
    @SerializedName("succursales")
    val succursales: List<Succursales>
)
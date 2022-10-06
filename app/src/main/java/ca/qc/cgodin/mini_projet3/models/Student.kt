package ca.qc.cgodin.mini_projet3.models


import com.google.gson.annotations.SerializedName

data class Student(
    @SerializedName("email")
    val email: String,
    @SerializedName("firstname")
    val firstname: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastname")
    val lastname: String,
    @SerializedName("matricule")
    val matricule: String,
    @SerializedName("password")
    val password: String
)
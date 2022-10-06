package ca.qc.cgodin.mini_projet3.models


import com.google.gson.annotations.SerializedName

data class StudentsResponse(
    @SerializedName("students")
    val students: String
)
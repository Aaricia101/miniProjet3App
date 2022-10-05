package ca.qc.cgodin.mini_projet3.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "student_table")
data class Student (@PrimaryKey(autoGenerate = true)
                    @ColumnInfo(name="id")
                    val id:Int,
                    @SerializedName("matricule")
                    val matricule: Int,
                    @SerializedName("firstname")
                    val firstname: String,
                    @SerializedName("lastname")
                    val lastname: String,
                    @SerializedName("pwd")
                    val pwd: String

                    ): Serializable
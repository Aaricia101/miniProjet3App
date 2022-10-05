package ca.qc.cgodin.mini_projet3.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "suc_table")
data class Succursale (@PrimaryKey(autoGenerate = true)
                        @ColumnInfo(name="no")
                        val no:Int,
                       @SerializedName("ville")
                        val ville: String,
                       @SerializedName("budget")
                        val budget: Int,
                       @SerializedName("matricule")
                        val matricule: Int): Serializable

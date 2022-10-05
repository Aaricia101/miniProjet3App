package ca.qc.cgodin.mini_projet3.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Entity(tableName = "response_table")
data class SucsResponse (@PrimaryKey(autoGenerate = true)
                         @ColumnInfo(name="id")
                         val id:Int,
                         @SerializedName("Suc")
                         val Suc: List<Succursale>,
                         @SerializedName("status")
                         val status: String,
                         @SerializedName("totalResults")
                         val totalResults: Int): Serializable
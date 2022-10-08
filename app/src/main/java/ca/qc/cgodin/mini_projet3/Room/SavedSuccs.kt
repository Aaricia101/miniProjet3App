package ca.qc.cgodin.mini_projet3.Room

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Entity(tableName = "succs_table")
data class SavedSuccs(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "AccesMdp")
    val accesMdp: String,
    @ColumnInfo(name = "Ville")
    val ville: String,
    @ColumnInfo(name = "Budget")
    val budget: String
)

@Dao
interface SuccDao{
    @Query("SELECT * FROM succs_table ORDER BY Ville ASC")
    fun getSSuccs(): LiveData<List<SavedSuccs>>

    @Query("SELECT * FROM succs_table WHERE Ville LIKE (:ville)")
    fun searchSSucc(ville: String): LiveData<List<SavedSuccs>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertSSucc(succ: SavedSuccs)

    @Update
    fun updateSSucc(succ: SavedSuccs)

    @Delete()
    fun deleteSSucc(succs: SavedSuccs)
}

@Database(entities = arrayOf(SavedSuccs::class), version = 1, exportSchema = false)
abstract class SSuccRoomDatabase: RoomDatabase() {
    abstract fun succDao(): SuccDao

    companion object{
        @Volatile
        private var INSTANCE: SSuccRoomDatabase? = null

        fun getDatabase(context: Context): SSuccRoomDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null)
            {
                return tempInstance
            }
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                SSuccRoomDatabase::class.java,
                "succs_database"
            ).build()
            return INSTANCE as SSuccRoomDatabase
        }
    }
}
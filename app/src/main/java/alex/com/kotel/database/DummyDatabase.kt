package alex.com.kotel.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Dummy::class), version = 1, exportSchema = false)
abstract class DummyDatabase : RoomDatabase() {
    abstract fun dummyDao(): DummyDAO
    companion object {
        @Volatile
        private var INSTANCE: DummyDatabase? = null
        fun getDatabase(context: Context): DummyDatabase {
            return INSTANCE ?: synchronized(this) {
               val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DummyDatabase::class.java,
                    "database"
                ).allowMainThreadQueries().build()
               INSTANCE
                instance //возвращает последнее
            }
        }
    }
}
package alex.com.kotel.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import java.util.ArrayList

@Dao
interface DummyDAO {

    @Query("SELECT*FROM Dummy")
    fun getAll(): Flow<List<Dummy>>

    @Query("SELECT*FROM Dummy")
    fun getAllSimple(): List<Dummy>   //only interface, will not work with ArrayList

    @Query("SELECT * FROM DUMMY WHERE id=:id")
    fun getDummyById(id: Int): Dummy

    @Query("DELETE FROM DUMMY WHERE id=:id")
    fun deleteDummyById(id: Int)

    @Insert
    fun insert(vararg dummy: Dummy)
}
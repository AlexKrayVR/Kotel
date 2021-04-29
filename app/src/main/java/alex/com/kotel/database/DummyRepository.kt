package alex.com.kotel.database

import androidx.annotation.WorkerThread
import androidx.room.Dao
import kotlinx.coroutines.flow.Flow


class DummyRepository (private val dummyDao: DummyDAO){

    val allWords: Flow<List<Dummy>> = dummyDao.getAll()
//    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(dummy: Dummy) {
        dummyDao.insert(dummy)
    }
}
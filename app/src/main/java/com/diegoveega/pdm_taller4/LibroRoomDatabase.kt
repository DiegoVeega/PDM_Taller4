package com.diegoveega.pdm_taller4

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.diegoveega.pdm_taller4.dao.AutorDao
import com.diegoveega.pdm_taller4.dao.LibroDao
import com.diegoveega.pdm_taller4.dao.TAGDao
import com.diegoveega.pdm_taller4.models.Autor
import com.diegoveega.pdm_taller4.models.Libro
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Libro::class], version = 1 ,exportSchema = false)
abstract class LibroRoomDatabase : RoomDatabase() {

    abstract fun libroDao(): LibroDao
    abstract fun autorDao(): AutorDao
    abstract fun TAGDao(): TAGDao

    companion object {
        @Volatile
        private var INSTANCE: LibroRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): LibroRoomDatabase {

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,LibroRoomDatabase::class.java,"libro_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(LibroDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class LibroDatabaseCallback(private val scope: CoroutineScope): RoomDatabase.Callback(){
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.libroDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(libroDao: LibroDao){
            libroDao.deleteAll()
        }
    }
}
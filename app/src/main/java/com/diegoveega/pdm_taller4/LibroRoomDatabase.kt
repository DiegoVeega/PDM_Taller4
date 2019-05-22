package com.diegoveega.pdm_taller4

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.diegoveega.pdm_taller4.dao.AutorDao
import com.diegoveega.pdm_taller4.dao.LibroDao
import com.diegoveega.pdm_taller4.dao.TAGDao
import com.diegoveega.pdm_taller4.models.Autor
import com.diegoveega.pdm_taller4.models.Libro

@Database(entities = [Libro::class], version = 1 ,exportSchema = false)
abstract class LibroRoomDatabase : RoomDatabase() {

    abstract fun libroDao(): LibroDao
    abstract fun autorDao(): AutorDao
    abstract fun TAGDao(): TAGDao

    companion object {
        @Volatile
        private var INSTANCE: LibroRoomDatabase? = null

        fun getDatabase(context: Context): LibroRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LibroRoomDatabase::class.java,
                    "Libro_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
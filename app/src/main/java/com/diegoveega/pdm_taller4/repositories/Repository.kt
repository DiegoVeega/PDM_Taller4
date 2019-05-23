package com.diegoveega.pdm_taller4.repositories

import android.app.Application
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.diegoveega.pdm_taller4.LibroRoomDatabase
import com.diegoveega.pdm_taller4.dao.AutorDao
import com.diegoveega.pdm_taller4.dao.LibroDao
import com.diegoveega.pdm_taller4.dao.TAGDao
import com.diegoveega.pdm_taller4.models.Autor
import com.diegoveega.pdm_taller4.models.Libro
import com.diegoveega.pdm_taller4.models.TAG
class Repository(private val libroDao: LibroDao, private val tagDao: TAGDao, private val autorDao: AutorDao){



    fun getAllLibros(): LiveData<List<Libro>> = libroDao.getAllLibros()
    fun deleteAlllibros()=libroDao.deleteAll()
    fun updateLibros(libro: Libro) = libroDao.updateLibros(libro)
    @WorkerThread
    suspend fun insertlibros(libro:Libro) = libroDao.insert(libro)

    fun getAllLtags(): LiveData<List<TAG>> = tagDao.getAllLibros()
    fun deleteAlltags()=tagDao.deleteAll()
    fun updatetags(tag: TAG) = tagDao.updateLibros(tag)
    @WorkerThread
    suspend fun inserttags(tag: TAG) = tagDao.insert(tag)

    fun getAllautor(): LiveData<List<Autor>> = autorDao.getAllLibros()
    fun deleteAllautor()=autorDao.deleteAll()
    fun updateautor(autor: Autor) = autorDao.updateLibros(autor)
    @WorkerThread
    suspend fun insertautor(autor: Autor) = autorDao.insert(autor)
}
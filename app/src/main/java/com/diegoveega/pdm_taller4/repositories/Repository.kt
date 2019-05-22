package com.diegoveega.pdm_taller4.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.diegoveega.pdm_taller4.dao.AutorDao
import com.diegoveega.pdm_taller4.dao.LibroDao
import com.diegoveega.pdm_taller4.dao.TAGDao
import com.diegoveega.pdm_taller4.models.Autor
import com.diegoveega.pdm_taller4.models.Libro
import com.diegoveega.pdm_taller4.models.TAG

class LibroRepo(private val libroDao: LibroDao){
    fun getAllLibros(): LiveData<List<Libro>> = libroDao.getAllLibros()

    fun deleteAll()=libroDao.deleteAll()

    fun updateLibros(libro: Libro) = libroDao.updateLibros(libro)

    @WorkerThread
    suspend fun insert(libro:Libro) = libroDao.insert(libro)


}
class TAGRepo(private val tagDao: TAGDao){
    fun getAllLibros(): LiveData<List<TAG>> = tagDao.getAllLibros()

    fun deleteAll()=tagDao.deleteAll()

    fun updateLibros(tag: TAG) = tagDao.updateLibros(tag)

    @WorkerThread
    suspend fun insert(tag: TAG) = tagDao.insert(tag)


}
class AutorRepo(private val autorDao: AutorDao){
    fun getAllLibros(): LiveData<List<Autor>> = autorDao.getAllLibros()

    fun deleteAll()=autorDao.deleteAll()

    fun updateLibros(autor: Autor) = autorDao.updateLibros(autor)

    @WorkerThread
    suspend fun insert(autor: Autor) = autorDao.insert(autor)

}

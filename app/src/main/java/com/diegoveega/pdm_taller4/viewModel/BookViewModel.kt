package com.diegoveega.pdm_taller4.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.diegoveega.pdm_taller4.LibroRoomDatabase
import com.diegoveega.pdm_taller4.dao.AutorDao
import com.diegoveega.pdm_taller4.models.Autor
import com.diegoveega.pdm_taller4.models.Libro
import com.diegoveega.pdm_taller4.models.TAG
import com.diegoveega.pdm_taller4.repositories.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class BookViewModel (app: Application) : AndroidViewModel(app){

    private val repository: Repository

    init {
        val LibroDao = LibroRoomDatabase.getIntance(app).libroDao()
        val TAGDao = LibroRoomDatabase.getIntance(app).TAGDao()
        val AutorDao = LibroRoomDatabase.getIntance(app).autorDao()

        repository = Repository(LibroDao, TAGDao, AutorDao)
    }

    //inserts
    fun insertBook(libro: Libro) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertlibros(libro)
    }

    fun insertAuthor(autor: Autor) = viewModelScope.launch(Dispatchers.IO){
        repository.insertautor(autor)
    }
    fun insertTag(tag: TAG) = viewModelScope.launch(Dispatchers.IO){
        repository.inserttags(tag)
    }

    //getAll
    fun getAllLibros(): LiveData<List<Libro>> = repository.getAllLibros()
    fun getAllAutor(): LiveData<List<Autor>> = repository.getAllautor()
    fun getAllTag(): LiveData<List<TAG>> = repository.getAlltags()

    //delete
    fun deleteAllLibros()= repository.deleteAllLibros()
    fun deleteAllAutor() = repository.deleteAllAutor()
    fun deleteAllTags() = repository.deleteAllTags()


}
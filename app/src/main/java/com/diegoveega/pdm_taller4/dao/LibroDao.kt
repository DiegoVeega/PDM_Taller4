package com.diegoveega.pdm_taller4.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.diegoveega.pdm_taller4.models.Libro


@Dao
interface LibroDao{

    @Query("SELECT * FROM libro_table ORDER BY nombre ASC")
    fun getAllLibros() : LiveData<List<Libro>>

    @Insert
    suspend fun insert(libro:Libro)

    @Update
    fun updateLibros(vararg libro: Libro)

    @Query("DELETE FROM libro_table")
    fun deleteAll()
}
package com.diegoveega.pdm_taller4.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.diegoveega.pdm_taller4.models.Autor

@Dao
interface AutorDao{

    @Query("SELECT * FROM autor_table ORDER BY nombre ASC")
    fun getAllLibros() : LiveData<List<Autor>>

    @Insert
    suspend fun insert(autor:Autor)

    @Update
    fun updateLibros(vararg autor: Autor)

    @Query("DELETE FROM autor_table")
    fun deleteAll()
}
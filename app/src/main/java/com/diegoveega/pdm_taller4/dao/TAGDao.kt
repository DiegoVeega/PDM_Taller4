package com.diegoveega.pdm_taller4.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.diegoveega.pdm_taller4.models.TAG

@Dao
interface TAGDao{

    @Query("SELECT * FROM TAG_table ORDER BY nombre ASC")
    fun getAllLibros() : LiveData<List<TAG>>

    @Insert
    suspend fun insert(tag:TAG)

    @Update
    fun updateLibros(vararg tag: TAG)

}
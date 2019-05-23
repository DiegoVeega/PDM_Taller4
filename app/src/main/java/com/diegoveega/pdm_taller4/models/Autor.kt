package com.diegoveega.pdm_taller4.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "autor_table")
data class Autor
    (@PrimaryKey (autoGenerate = true) val id_autor: Int,
     @ColumnInfo(name = "nombre") val nombre_autor : String,
     @ColumnInfo(name = "apellido") val apellido_autor : String,
     @ColumnInfo(name = "libro") val libro_autor : Libro)
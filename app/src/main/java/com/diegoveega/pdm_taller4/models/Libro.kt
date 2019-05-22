package com.diegoveega.pdm_taller4.models

import android.media.Image
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "libro_table")
data class Libro
    (@PrimaryKey @ColumnInfo(name= "nombre") val nombre_libro: String,
     @ColumnInfo(name = "autores") val autores_libro: Autor,
     @ColumnInfo(name = "ISBN") val isbn_libro: String,
     @ColumnInfo(name = "caratula") val caratula_libro: Int,
     @ColumnInfo(name = "resumen") val resumen_libro: String,
     @ColumnInfo(name = "tags") val tags_libro: TAG,
     @ColumnInfo(name = "favorito") val favorito_libro: Boolean)
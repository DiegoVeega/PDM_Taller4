package com.diegoveega.pdm_taller4.models

import android.media.Image
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity (
 tableName = "libro_table",
 foreignKeys =
         arrayOf(
           ForeignKey(
            entity = Autor::class,
            parentColumns = arrayOf("nombre_autor"),
            childColumns = arrayOf("autores"),
            onDelete = ForeignKey.CASCADE
           ),

           ForeignKey(
            entity = TAG::class,
            parentColumns = arrayOf("nombre_TAG"),
            childColumns = arrayOf("tags"),
            onDelete = ForeignKey.CASCADE
           )
         )
 )
data class Libro
    (@PrimaryKey (autoGenerate = true) val id_libro: Int,
     @ColumnInfo(name= "nombre") val nombre_libro: String,
     @ColumnInfo(name = "autores") val autores_libro: String,
     @ColumnInfo(name = "ISBN") val isbn_libro: String,
     @ColumnInfo(name = "caratula") val caratula_libro: Int,
     @ColumnInfo(name = "resumen") val resumen_libro: String,
     @ColumnInfo(name = "tags") val tags_libro: String,
     @ColumnInfo(name = "favorito") val favorito_libro: Boolean)


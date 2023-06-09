package com.example.notepad2.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//On creer la data class note ici pour nous aider a recup les el de notes a stocker dans la BD

@Entity(tableName = "notes_table")
data class Note (
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "note") val note: String?,
    @ColumnInfo(name = "date") val date: String?
        ): java.io.Serializable
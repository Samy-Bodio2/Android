package com.example.notepad2.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notepad2.Models.Note
import com.example.notepad2.Utilities.DATABASE_NAME

// Cette classe va jouer le role de base de donnees et lors du fonctionnemnent de l'app
//un objet de la classe se doit d'etre instancie
@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {//type de bd utiliser dans le projet{

    abstract fun getNoteDao() : NoteDao

    companion object{
        @Volatile
        private var INSTANCE : NoteDatabase? = null //L'instance de la classe database a etre instancie
        //lors du demarrage de l'App
        fun getDatabase(context: Context) : NoteDatabase{
            return INSTANCE ?: synchronized(this){//sync va syn
                val instance = Room.databaseBuilder(//creation de la BD
                    context.applicationContext,
                    NoteDatabase::class.java,
                    DATABASE_NAME
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}
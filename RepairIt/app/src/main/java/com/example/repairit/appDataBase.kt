package com.example.repairit

import Classes.Usuario
import Interfaces.UsuarioDAO
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Usuario::class], version = 1)
abstract class appDataBase:RoomDatabase() {

    abstract fun usuarioDAO():UsuarioDAO

    companion object{
        @Volatile
        private var INSTANCE:appDataBase?=null

        fun getDatabase(context: Context):appDataBase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    appDataBase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
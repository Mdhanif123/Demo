package com.example.form

import androidx.room.Database
import androidx.room.RoomDatabase



@Database(entities = [Entitty::class]  , version = 2, exportSchema = false)
abstract class DB: RoomDatabase() {

    abstract fun dao() : Dao

}
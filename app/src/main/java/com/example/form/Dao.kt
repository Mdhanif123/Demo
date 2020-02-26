package com.example.form

import android.content.EntityIterator
import androidx.room.*
import androidx.room.Dao


@Dao
interface Dao {

    @Insert
    fun insertdata(student: Entitty)

    @Query("select * from Entitty")
    fun readData() : List<Entitty>

    @Delete
    fun deleteData(delStudent : Entitty)

    @Update
    fun updateData(updateStudent : Entitty)

}
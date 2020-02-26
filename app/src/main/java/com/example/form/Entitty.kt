package com.example.form

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Entitty {



    @PrimaryKey()
    var enroll_no: String = ""

    @ColumnInfo(name = "Student Name")
    var name:String = ""

    @ColumnInfo(name = "Student Department")
    var department:String = ""



}
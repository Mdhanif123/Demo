package com.example.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_submit.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.thread

class Submit : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)
        val students = ArrayList<StudentDataClass>()
        recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        var database = Room.databaseBuilder(applicationContext,DB::class.java,"Student Database").fallbackToDestructiveMigration().build()
        var student = Entitty()

        val readDataThread = Thread {
            database.dao().readData().forEach {
                students.add(StudentDataClass(it.name,it.enroll_no,it.department))
            }
        }
        readDataThread.start()


        intent.extras?.let{
            val studentName = it.get ("StudentName").toString()
            val studentEnrollNumber = it.get("StudentEnrollNumber").toString()
            val studentdepartment = it.get("StudentDepartment").toString()

            val saveDataThread = Thread{
                student.name = studentName
                student.enroll_no = studentEnrollNumber
                student.department = studentdepartment
                database.dao().insertdata(student)
            }
            saveDataThread.start()

        }

        btnshowData.setOnClickListener {

            students.clear()

            val readDataThread = Thread {
                database.dao().readData().forEach {
                    students.add(StudentDataClass(it.name,it.enroll_no,it.department))
                }
            }
            readDataThread.start()

            val adapter = AdapterViewClass(students)
            recyclerView.adapter = adapter

        }

        btnupdateData.setOnClickListener {

            val updateStudent = Entitty()
            updateStudent.enroll_no = showNumber.text.toString()
            updateStudent.name = showName.text.toString()
            updateStudent.department = showDepartment.text.toString()

            val updateThread = Thread{

                database.dao().updateData(updateStudent)

            }
            updateThread.start()

            Toast.makeText(this,"Data has been updated please click on \"Show Data\" to check updated database",Toast.LENGTH_SHORT).show()


        }

        btndeleteData.setOnClickListener {
            val delStudent = Entitty()
            delStudent.enroll_no = showNumber.text.toString()

            var delThread = Thread{
                database.dao().deleteData(delStudent)
            }
            delThread.start()

            Toast.makeText(this,"Data has been deleted please click on \"Show Data\" to check updated database",Toast.LENGTH_SHORT).show()


        }

    }
}

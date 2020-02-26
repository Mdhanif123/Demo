package com.example.form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import android.view.View
import android.widget.*
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btnsubmit.setOnClickListener {

            val dept = spinner.selectedItem
            val intent = Intent(this, Submit::class.java)
            intent.putExtra("StudentName",name.text)
            intent.putExtra("StudentEnrollNumber",number.text)
            intent.putExtra("StudentDepartment",dept.toString())
            startActivity(intent)
        }


        val ColorRippleEffect = ContextCompat.getColor(applicationContext, R.color.Blue)
        fab_btn.rippleColor = ColorRippleEffect


        fab_btn.setOnClickListener{

        }

        val values = resources.getStringArray(R.array.Values)

        if (spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, values)
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    Toast.makeText(this@MainActivity, getString(R.string.selected_item) + " " + "" + values[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    Toast.makeText(this@MainActivity, "Please Select Something in Department",Toast.LENGTH_SHORT).show()
                }

            }

        }





    }
}

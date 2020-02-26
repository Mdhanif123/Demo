package com.example.form

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterViewClass(val students: ArrayList<StudentDataClass>) :
    RecyclerView.Adapter<AdapterViewClass.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.listlayout,parent,false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val student: StudentDataClass = students[position]

        holder.textViewName?.text = student.name
        holder.textViewNumber?.text = student.number
        holder.textViewDepartment?.text = student.department

    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val textViewName: TextView? = itemView.findViewById(R.id.txtViewName)
        val textViewNumber: TextView? = itemView.findViewById(R.id.txtViewNumber)
        val textViewDepartment: TextView? = itemView.findViewById(R.id.txtViewDepartment)

    }



}
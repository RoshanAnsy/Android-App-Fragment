package com.example.agecal

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button=findViewById<Button>(R.id.button1)

        button.setOnClickListener { view->
            printAge(view)

        }
    }
   // @RequiresApi(Build.VERSION_CODES.N)
    private fun printAge(view: View){
        val myCalender= Calendar.getInstance()
        val year=myCalender.get(Calendar.YEAR)
        val month=myCalender.get(Calendar.MONTH)
        val day=myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{View,year,month,day ->
          val seletedDate="$day/${month+1}/$year"
                val textView1=findViewById<TextView>(R.id.text1)
                textView1.text=seletedDate

                val dob=Calendar.getInstance()
                dob.set(year,month,day)
                var age=myCalender.get(Calendar.YEAR)-dob.get(Calendar.YEAR)
                if(myCalender.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR) {
                        age--
                    }
                  val textView2=findViewById<TextView>(R.id.text2)

                textView2.text="you are $age old person"



            }
          ,year,
        month,
        day).show()


    }
}
package com.example.grafy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var editI : EditText = findViewById(R.id.edit_i)
        var editJ : EditText = findViewById(R.id.edit_j)
        var buttonIPlus : Button = findViewById(R.id.button_i_plus)
        var buttonIMinus : Button = findViewById(R.id.button_i_minus)
        var buttonJPlus : Button = findViewById(R.id.button_j_plus)
        var buttonJMinus : Button = findViewById(R.id.button_j_minus)

        buttonIPlus.setOnClickListener {
            if(editI.text.isNullOrBlank()){
                editI.setText("0")
            }else{
                if(editI.text.toString().equals("9")){

                }else{
                    var zmienna = editI.text.toString().toInt()
                    editI.setText((zmienna+1).toString())
                }
            }
        }
        buttonIMinus.setOnClickListener {
            if(editI.text.isNullOrBlank()){
                editI.setText("0")
            }else{
                if(editI.text.toString().equals("0")){

                }else{
                    var zmienna = editI.text.toString().toInt()
                    editI.setText((zmienna-1).toString())
                }
            }
        }
        buttonJPlus.setOnClickListener {
            if(editJ.text.isNullOrBlank()){
                editJ.setText("0")
            }else{
                if(editJ.text.toString().equals("9")){

                }else{
                    var zmienna = editJ.text.toString().toInt()
                    editJ.setText((zmienna+1).toString())
                }
            }
        }
        buttonJMinus.setOnClickListener {
            if(editJ.text.isNullOrBlank()){
                editJ.setText("0")
            }else{
                if(editJ.text.toString().equals("0")){

                }else{
                    var zmienna = editJ.text.toString().toInt()
                    editJ.setText((zmienna-1).toString())
                }
            }
        }
    }
}
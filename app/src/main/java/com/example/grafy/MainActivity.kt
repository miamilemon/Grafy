package com.example.grafy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

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
        var button1 : Button = findViewById(R.id.button_1)
        var wynik : TextView = findViewById(R.id.text_wynik)

        var tablica = arrayOf<Array<Int>>(
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(0, 2, 4, 6, 8, 10, 12, 14, 16, 18),
            arrayOf(0, 3, 6, 9, 12, 15, 18, 21, 24, 27),
            arrayOf(0, 4, 8, 12, 16, 20, 24, 28, 32, 35),
            arrayOf(0, 5, 10, 15, 20, 25, 30, 35, 40, 45),
            arrayOf(0, 6, 12, 18, 24, 30, 36, 42, 48, 54),
            arrayOf(0, 7, 14, 21, 28, 35, 42, 49, 56, 63),
            arrayOf(0, 8, 16, 24, 32, 40, 48, 56, 64, 72),
            arrayOf(0, 9, 18, 27, 36, 45, 54, 63, 72, 81)
        )
        button1.setOnClickListener {
            var jeden = tablica[editI.text.toString().toInt()]
            wynik.text = jeden[editJ.text.toString().toInt()].toString()
        }

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
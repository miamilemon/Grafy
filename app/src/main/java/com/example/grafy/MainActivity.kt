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
        var buttonWartosc : Button = findViewById(R.id.button_wartosc)
        var buttonZmiana : Button = findViewById(R.id.button_zmien)
        var wynik : EditText = findViewById(R.id.text_wynik)
        //graf 5 elementowy z połączeniami bezkierunkowymi (obustronnymi)
        //0 oznacza brak połączenia, a każda liczba odjąć 1 wagę połączenia
        var tablica = arrayOf<Array<Int>>(
            arrayOf(0, 6, 4, 2, 0),
            arrayOf(6, 0, 0, 0, 8),
            arrayOf(4, 0, 0, 3, 0),
            arrayOf(2, 0, 3, 0, 5),
            arrayOf(0, 8, 0, 5, 0)
        )
        buttonWartosc.setOnClickListener {
            var jeden = tablica[editI.text.toString().toInt()]
            wynik.setText(jeden[editJ.text.toString().toInt()].toString())
        }

        buttonZmiana.setOnClickListener {
            var jeden = tablica[editI.text.toString().toInt()]
            jeden[editJ.text.toString().toInt()] = wynik.text.toString().toInt()
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
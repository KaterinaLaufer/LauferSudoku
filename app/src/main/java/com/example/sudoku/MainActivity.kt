package com.example.sudoku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
class MainActivity : AppCompatActivity() {

    //Кнопки
    internal lateinit var aboutButton: Button
    internal lateinit var continueButton: Button
    internal lateinit var newButton: Button
    internal lateinit var exitButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Находим кнопки по ИД
        aboutButton = findViewById(R.id.about_button)
        continueButton = findViewById(R.id.continue_button)
        newButton = findViewById(R.id.new_button)
        exitButton = findViewById(R.id.exit_button)

        aboutButton.setOnClickListener() { view ->
            val aboutIntent = Intent(this, About::class.java)
            startActivity(aboutIntent)
        }
    }

    public fun onClickButton(view: View){
        val aboutIntent = Intent(this, About::class.java)
        startActivity(aboutIntent)
    }
}
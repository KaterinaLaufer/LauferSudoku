package com.example.sudoku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Debug
import android.util.Log

class MainActivity : AppCompatActivity() {

    //Кнопки
    internal lateinit var aboutButton: Button
    internal lateinit var continueButton: Button
    internal lateinit var newButton: Button
    internal lateinit var exitButton: Button

    //функция сборки
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Находим кнопки по ИД
        aboutButton = findViewById(R.id.about_button)
        continueButton = findViewById(R.id.continue_button)
        newButton = findViewById(R.id.new_button)
        exitButton = findViewById(R.id.exit_button)

        //Вешаем события на кнопки
        //TODO разобраться как оптимизировать этот гавнокод
        aboutButton.setOnClickListener() { view ->
            onClickButton(view)
        }
        newButton.setOnClickListener() { view ->
            onClickButton(view)
        }
        exitButton.setOnClickListener() { view ->
            onClickButton(view)
        }
    }
    //Функция разведения действия с кнопками
    fun onClickButton(view: View){
        when (view.id){
            //Кнопка о программе, открывает активити
             R.id.about_button -> {
                val aboutIntent = Intent(this, About::class.java)
                startActivity(aboutIntent)
            }
            //Кнопка старта игры, вызывает всплывающий диалог, после чего стартует игра
            R.id.new_button->{
                openNewGameDialog();
            }
            //Кнопка выхода из приложения
            R.id.exit_button->{
                finish()
            }
        }
    }
    //Функция открытия диалога с выбором сложности и стартом игры
    private fun openNewGameDialog() {
        val alertDialogBuilder=AlertDialog.Builder(this)
        alertDialogBuilder.setTitle(R.string.difficult_label)
        alertDialogBuilder.setItems(R.array.difficulty, DialogInterface.OnClickListener {dialogInterface, i ->  startGame(i)})
        alertDialogBuilder.show()
    }
    //Функция старта игры
    private fun startGame(i: Int) {
        //Записываем в лог какое значение было выбрано
        Log.d("Sudoku", "clicked on " +i)
    }
    //Функция формирования всплывающего меню (правый верхний угол)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.context_menu, menu)
        return true
    }
    //Функция формирования страницы настроек
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.settings) {
            val prefIntent = Intent(this, Pref::class.java)
            startActivity(prefIntent)
        }
        return true
    }
}
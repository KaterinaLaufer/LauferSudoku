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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Находим кнопки по ИД
        aboutButton = findViewById(R.id.about_button)
        continueButton = findViewById(R.id.continue_button)
        newButton = findViewById(R.id.new_button)
        exitButton = findViewById(R.id.exit_button)

        aboutButton.setOnClickListener() { view ->
            onClickButton(view)
            //val aboutIntent = Intent(this, About::class.java)
            //startActivity(aboutIntent)
        }
        newButton.setOnClickListener() { view ->
            onClickButton(view)
        }
    }

    fun onClickButton(view: View){
       /* if(view.id==R.id.about_button){
            val aboutIntent = Intent(this, About::class.java)
            startActivity(aboutIntent)
        }*/
        when (view.id){
             R.id.about_button -> {
                val aboutIntent = Intent(this, About::class.java)
                startActivity(aboutIntent)
            }
            R.id.new_button->{
                openNewGameDialog();
            }
        }
    }

    private fun openNewGameDialog() {
        val alertDialogBuilder=AlertDialog.Builder(this)
        alertDialogBuilder.setTitle(R.string.difficult_label)
        alertDialogBuilder.setItems(R.array.difficulty, DialogInterface.OnClickListener {dialogInterface, i ->  startGame(i)})
        alertDialogBuilder.show()
        //alertDialogBuilder.create()
    }

    private fun startGame(i: Int) {
        Log.d("Sudoku", "clicked on " +i)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.context_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.settings) {
            val prefIntent = Intent(this, Pref::class.java)
            startActivity(prefIntent)
        }
        return true
    }
}
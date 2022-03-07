package com.example.sudoku

import android.os.Bundle
import android.preference.PreferenceActivity
//Формирование меню настроек из файла настроек
class Pref: PreferenceActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.settings)
    }
}
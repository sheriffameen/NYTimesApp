package com.example.nytimesapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nytimesapplication.R
import com.example.nytimesapplication.navigator.AppNavigator
import com.example.nytimesapplication.navigator.Screens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigator.navigateTo(Screens.SEARCH)
    }
}
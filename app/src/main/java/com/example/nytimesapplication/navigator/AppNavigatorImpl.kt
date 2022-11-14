package com.example.nytimesapplication.navigator

import androidx.fragment.app.FragmentActivity
import com.example.nytimesapplication.R
import com.example.nytimesapplication.ui.SearchFragment
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor(private val activity: FragmentActivity) : AppNavigator {
    override fun navigateTo(screen: Screens) {
        val fragment = when(screen){
            Screens.SEARCH -> SearchFragment()
        }

        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(fragment::class.java.canonicalName)
            .commit()
    }

}
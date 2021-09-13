package com.example.joeywanandroid

import android.os.Build

import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"


    private val navHostFragments = ArrayList<Fragment>()
    private val itemToDes =
        mapOf(R.id.bottom_nav_home to 0, R.id.bottom_nav_account to 1, R.id.bottom_nav_website to 2)
    private var prevBottomItemId = -1

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomnav_view)

        val topDestinations = listOf(R.navigation.home_graph, R.navigation.account_graph, R.navigation.website_graph)
        if (savedInstanceState == null)
            for (topDestination in topDestinations)
                navHostFragments.add(NavHostFragment.create(topDestination))


        val transaction = supportFragmentManager.beginTransaction()
        for (i in navHostFragments.indices) {
            transaction.add(R.id.frg_container, navHostFragments[i])
            if (i == 0)
                transaction.show(navHostFragments[i])
            else
                transaction.hide(navHostFragments[i])
        }
        transaction.commit()


        bottomNavigationView.setOnNavigationItemSelectedListener {
            if (prevBottomItemId == it.itemId) {
                true
            } else {
                val transaction2 = supportFragmentManager.beginTransaction()
                for (key in itemToDes.keys) {
                    if (it.itemId == key)
                        transaction2.show(navHostFragments[itemToDes[key]!!])
                    else
                        transaction2.hide(navHostFragments[itemToDes[key]!!])
                }
                transaction2.commit()
                prevBottomItemId = it.itemId
                true
            }
        }
    }

}
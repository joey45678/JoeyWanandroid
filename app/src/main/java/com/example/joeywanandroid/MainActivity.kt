package com.example.joeywanandroid

import android.os.Build

import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val  bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomnav_view)
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host
        ) as NavHostFragment
        navController = navHostFragment.navController

        bottomNavigationView.setupWithNavController(navController)

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.frg_home, R.id.frg_account,  R.id.frg_website)
        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }
}
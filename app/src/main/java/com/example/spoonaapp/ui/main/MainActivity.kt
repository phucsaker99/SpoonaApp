package com.example.spoonaapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.example.spoonaapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val navController by lazy { navHostFragment.findNavController() }
    private val navHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.fragmentHomeContainer) as NavHostFragment }
    private val appBarConfiguration by lazy {
        AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.searchFragment
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.searchFragment -> {
                toolbarMain.title = resources.getString(R.string.text_search)
            }
            R.id.homeFragment -> {
                toolbarMain.title = resources.getString(R.string.text_home)
            }
        }
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp() =
        navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    private fun initView() {
        navBottomMain.setupWithNavController(navController)
        setSupportActionBar(toolbarMain)
        setupActionBarWithNavController(
            navController,
            appBarConfiguration
        )
    }
}

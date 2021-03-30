package com.example.spoonacularapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.example.spoonacularapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private var navHostFragment: NavHostFragment? = null
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavController()
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


    private fun initNavController() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentHomeContainer) as NavHostFragment
        navController = navHostFragment?.findNavController()!!
        appBarConfiguration =
            AppBarConfiguration(
                setOf(
                    R.id.homeFragment,
                    R.id.searchFragment
                )
            )
    }

    private fun initView() {
        navBottom.setupWithNavController(navController)
        setSupportActionBar(toolbarMain)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}

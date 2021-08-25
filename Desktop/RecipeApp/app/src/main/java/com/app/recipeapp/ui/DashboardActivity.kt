package com.app.recipeapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.app.recipeapp.R
import com.app.recipeapp.api.ServiceBuilder
import com.app.recipeapp.databinding.ActivityDashboardBinding
import com.app.recipeapp.global.GlobalClass
import com.app.recipeapp.ui.fragments.FavouriteFragment
import com.app.recipeapp.ui.fragments.ProfileFragment
import com.app.recipeapp.ui.fragments.RecipeFragment

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addActionBarIcon()
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        createDashboardButtonNavigation()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_custom_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miLogout -> {
                val sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE)
                sharedPreferences.apply { edit().clear().apply() }
                ServiceBuilder.token = null
                startActivity(Intent(this, LoginActivity::class.java))

            }
        }
        return true
    }

    private fun addActionBarIcon() {
//        supportActionBar?.setDisplayShowHomeEnabled(true)
//        supportActionBar?.setIcon(R.drawable.ic_cooking_logo)

        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.custom_toolbar)
    }


    private fun createDashboardButtonNavigation() {
        val fragmentRecipe = RecipeFragment()
        val fragmentFavourite = FavouriteFragment()
        val profileFragment = ProfileFragment()
        setCurrentFragment(fragmentRecipe)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.miRecipe -> setCurrentFragment(fragmentRecipe)
                R.id.miFav -> setCurrentFragment(fragmentFavourite)
                R.id.miProfile -> setCurrentFragment(profileFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragmentNavigation, fragment)
            commit()
        }

    }
}
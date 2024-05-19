package com.example.myapplication

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityNavigationAvtivityBinding
import com.google.android.material.navigation.NavigationView

class NavigationAvtivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    lateinit var navigationBinding: ActivityNavigationAvtivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigationBinding = ActivityNavigationAvtivityBinding.inflate(layoutInflater)
        setContentView(navigationBinding.root)
        setSupportActionBar(navigationBinding.toolbar)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            window.statusBarColor = ContextCompat.getColor(this, com.google.android.material.R.color.m3_ref_palette_black)
        }

        var toggle = ActionBarDrawerToggle(
            this, navigationBinding.drawerLayout,
            navigationBinding.toolbar, R.string.open_drawer, R.string.close_drawer
        )
        navigationBinding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigationBinding.navigationView.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HomeFragment())
                .commit()
        }

    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.home -> {
                title = "Home"
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HomeFragment())
                    .commit()
            }
            R.id.search -> {
                title = "Search"
                supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, SearchFragment()).commit()}
            R.id.favourite -> {
                title = "Favourite"
                supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, FavouriteFragment()).commit()}
            R.id.profile -> {
                title = "Profile"
                supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, ProfileFragment()).commit()}
        }
        navigationBinding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (navigationBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            navigationBinding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed() // Move this line inside the else block
        }
    }
}
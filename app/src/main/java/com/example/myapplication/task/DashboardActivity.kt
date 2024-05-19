package com.example.myapplication.task

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    lateinit var dashboardBindind:ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashboardBindind = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(dashboardBindind.root)
        replaceFragment(TheHomeFragment())

        dashboardBindind.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(TheHomeFragment())
                R.id.search -> replaceFragment(TheSearchFragment())
                R.id.profile -> replaceFragment(TheProfileFragment())
                else ->{}
            }
            true
        }


    }
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()

    }
}
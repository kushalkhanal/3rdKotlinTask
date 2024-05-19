package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.databinding.ActivityDashboardAvtivityBinding

class DashboardAvtivity : AppCompatActivity() {
    lateinit var navBarBinding: ActivityDashboardAvtivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        navBarBinding = ActivityDashboardAvtivityBinding.inflate(layoutInflater)
        setContentView(navBarBinding.root)
        replaceFragment(HomeFragment())

        navBarBinding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.search -> replaceFragment(SearchFragment())
                R.id.favourite -> replaceFragment(FavouriteFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
                else -> {}

            }
            true
        }

    }
    private fun replaceFragment(fragment:Fragment){
        val fragmentManager:FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }
}

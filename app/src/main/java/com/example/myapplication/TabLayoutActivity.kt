package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.adapter.TabAdapter
import com.example.myapplication.databinding.ActivityTabLayoutBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutActivity : AppCompatActivity() {
    lateinit var tabBarBinding: ActivityTabLayoutBinding
    var tabList = arrayOf("Home","Search","Profile")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tabBarBinding=ActivityTabLayoutBinding.inflate(layoutInflater)
        setContentView(tabBarBinding.root)


        tabBarBinding.viewPager2.adapter = TabAdapter(supportFragmentManager,lifecycle)

        TabLayoutMediator(tabBarBinding.tabLayout,tabBarBinding.viewPager2){
            tab,position ->tab.text = tabList[position]
        }.attach()
    }
}
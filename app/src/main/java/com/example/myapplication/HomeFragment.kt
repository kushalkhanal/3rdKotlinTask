package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.splashandbutton.adapter.SportsAdapter

class HomeFragment : Fragment() {
     lateinit var homeBinding: FragmentHomeBinding
     val titleList = ArrayList<String>()
     val imageList = ArrayList<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)

        titleList.add("Basketball")
        imageList.add(R.drawable.basketball)
        titleList.add("Football")
        imageList.add(R.drawable.football)
        titleList.add("Cricket")
        imageList.add(R.drawable.cricket)
        titleList.add("Handball")
        imageList.add(R.drawable.handball)

        var adapter = SportsAdapter(titleList,imageList)

        homeBinding.recyclerView.layoutManager = LinearLayoutManager(context)
        homeBinding.recyclerView.adapter = adapter


        return homeBinding.root
    }
}

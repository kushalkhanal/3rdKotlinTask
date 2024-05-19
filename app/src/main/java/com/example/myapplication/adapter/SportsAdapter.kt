package com.example.splashandbutton.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

import de.hdodenhof.circleimageview.CircleImageView

class SportsAdapter(var titleList: ArrayList<String>,
                    var imageList: ArrayList<Int>) : RecyclerView.Adapter<SportsAdapter.SportsViewHolder>() {

    class SportsViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var title : TextView = view.findViewById(R.id.textView2)
        var image : CircleImageView = view.findViewById(R.id.profile_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        var view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.sample_recycler_view,parent,false)

        return SportsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return titleList.size
    }

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        holder.title.text = titleList[position]
        holder.image.setImageResource(imageList[position])
    }
}
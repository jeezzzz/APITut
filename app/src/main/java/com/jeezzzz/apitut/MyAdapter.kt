package com.jeezzzz.apitut

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val users: List<User>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title=itemView.findViewById<TextView>(R.id.userTxt)
        var image=itemView.findViewById<ImageView>(R.id.userImg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=LayoutInflater.from(context).inflate(R.layout.custom_user,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.text=users[position].firstName+" "+users[position].lastName
        //glide
        Glide.with(context).load(users[position].image).into(holder.image)
        //picaso
//        Picasso.get().load(users[position].image).into(holder.image)
    }
}
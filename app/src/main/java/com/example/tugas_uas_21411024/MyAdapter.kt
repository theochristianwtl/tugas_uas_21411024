package com.example.tugas_uas_21411024

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (var mContext: Context, var movieList: List<Movie>):
    RecyclerView.Adapter<MyAdapter.ListViewHolder>()
{
        inner class ListViewHolder(var v: View): RecyclerView.ViewHolder(v){
            var img = v.findViewById<ImageView>(R.id.imageMovie)
            var name = v.findViewById<TextView>(R.id.imageTitle)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var v = inflater.inflate(R.layout.data_item,parent, false)
        return ListViewHolder(v)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MyAdapter.ListViewHolder, position: Int) {
        var newList = movieList[position]
        holder.name.text = newList.name
        holder.img.loadImage(newList.imageUrl)
        holder.v.setOnClickListener{

            val name = newList.name
            val desc = newList.description
            val imgUrl = newList.imageUrl

            val mIntent = Intent(mContext, DetailActivity::class.java)
            mIntent.putExtra("name",name)
            mIntent.putExtra("desc", desc)
            mIntent.putExtra("imgUrl",imgUrl)
            mContext.startActivity(mIntent)
        }
    }
}
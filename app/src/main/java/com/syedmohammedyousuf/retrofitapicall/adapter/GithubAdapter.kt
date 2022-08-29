package com.syedmohammedyousuf.retrofitapicall.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.syedmohammedyousuf.retrofitapicall.R
import com.syedmohammedyousuf.retrofitapicall.model.GithubResponse

class GithubAdapter(private var mList: List<GithubResponse>): RecyclerView.Adapter<GithubAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_github_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: GithubAdapter.ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]

        holder.title.text = ItemsViewModel.title
        holder.date.text = ItemsViewModel.created_at

    }

    override fun getItemCount(): Int {

        return mList.size
    }

     class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val title: MaterialTextView = itemView.findViewById(R.id.tvTitle)
        val date: MaterialTextView = itemView.findViewById(R.id.tvDate)


    }
}
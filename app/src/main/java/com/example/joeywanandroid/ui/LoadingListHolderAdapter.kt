package com.example.joeywanandroid.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.joeywanandroid.R

class LoadingListHolderAdapter: RecyclerView.Adapter<ListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        return ListHolder(parent)
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 7
    }


}
class ListHolder(parent :ViewGroup) :RecyclerView.ViewHolder(   LayoutInflater.from(parent.context).inflate(
    R.layout.loading_list_ltr, parent, false)
){

}
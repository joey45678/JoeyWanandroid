package com.example.joeywanandroid.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.joeywanandroid.R

class LoadingListHolderAdapter : RecyclerView.Adapter<ListHolder>() {
    private val BANNER = 66
    private var showBanner = false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {

        if (showBanner && viewType == BANNER) {
            return ListHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.holder_banner, parent, false
                ) as ViewGroup
            )
        } else {
            return ListHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.loading_list_ltr, parent, false
                ) as ViewGroup
            )
        }


    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 7
    }

    override fun getItemViewType(position: Int): Int {
        if (showBanner && position == 0)
            return BANNER
        return super.getItemViewType(position)
    }

    fun setShowBanner(show: Boolean) {
        showBanner = show
    }
}

class ListHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent) {

}
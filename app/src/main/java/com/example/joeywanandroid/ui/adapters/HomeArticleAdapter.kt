package com.example.joeywanandroid.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.joeywanandroid.bean.ArticleBean
import com.example.joeywanandroid.databinding.ItemArticleBinding

class HomeArticleAdapter(): RecyclerView.Adapter<ArticleHolder>() {

    val articleBeans = ArrayList<ArticleBean>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleHolder {
        return ArticleHolder(  ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ArticleHolder, position: Int) {
        holder.bind(articleBeans.get(position))
        val pTime  = articleBeans.get(position).publishTime
        val startTs = System.currentTimeMillis()
        holder.setNew((startTs - pTime) < 86400000*3)
    }

    override fun getItemCount(): Int {
        return articleBeans.size
    }


}
class ArticleHolder( private val binding:ItemArticleBinding) :RecyclerView.ViewHolder( binding.root){
    fun setNew(isNew: Boolean){
        binding.itemArticleIsNew.text = if(isNew) "NEW   " else ""
    }
    fun bind(bean:ArticleBean){
        binding.apply {
            articleBean = bean
            executePendingBindings()
        }
    }

}
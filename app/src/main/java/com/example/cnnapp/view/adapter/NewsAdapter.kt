package com.example.cnnapp.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cnnapp.R
import com.example.cnnapp.common.inflate
//import com.example.cnnapp.common.loadImage

import com.example.cnnapp.model.Articles
import com.example.cnnapp.model.CnnModel
import kotlinx.android.synthetic.main.fragment_recycler_view.view.*



class NewsAdapter (private val cnnModel: CnnModel, private val listener: OnListClickLister):
    RecyclerView.Adapter<ListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        val view: View = parent.inflate(R.layout.fragment_recycler_view, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  cnnModel.articles.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        holder.tvTitle.text = cnnModel.articles[position].title
        holder.tvDescription.text = cnnModel.articles[position].description
//        holder.imgView.loadImage(cnnModel.articles[position].urlToImage)
        holder.bind(cnnModel.articles[position], listener)
    }
}

class ListViewHolder (view: View): RecyclerView.ViewHolder(view){

    fun bind (articles: Articles, listener: OnListClickLister){
        itemView.setOnClickListener{
            listener.onListClick(articles)
        }
    }

    val tvTitle = view.tv_title
    val tvDescription = view.tv_description
    val imgView = view.iv_news_logo
}

interface OnListClickLister{

    fun onListClick(articles: Articles)
}
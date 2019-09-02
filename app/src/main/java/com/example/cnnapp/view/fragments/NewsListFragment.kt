package com.example.cnnapp.view.fragments


import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cnnapp.R

import com.example.cnnapp.model.Articles
import com.example.cnnapp.model.CnnModel
import com.example.cnnapp.presenter.PresenterImp
import com.example.cnnapp.presenter.ViewInterface
import com.example.cnnapp.view.adapter.NewsAdapter
import com.example.cnnapp.view.adapter.OnListClickLister
import kotlinx.android.synthetic.main.fragment_news_list.*

class NewsListFragment : Fragment(), ViewInterface {

    private lateinit var presenterImp: PresenterImp

    override fun showProgress() {

    }

    override fun showError() {
    }

    override fun onShowList(cnnModel: CnnModel) {


        val adapter: NewsAdapter =
            NewsAdapter(cnnModel, object : OnListClickLister {

                    override fun onListClick(articles: Articles) {
                        val url = articles.url
                        val builder = CustomTabsIntent.Builder()

                        val customTabsIntent: CustomTabsIntent = builder.build()
                        customTabsIntent.launchUrl(activity, Uri.parse(url))
                    }
            })

        rv_list.layoutManager = LinearLayoutManager(activity)
        rv_list.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        presenterImp.onDestroy()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenterImp = PresenterImp(this)
        presenterImp.processCall()
        showProgress()
    }
}

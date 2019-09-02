package com.example.cnnapp.presenter

import android.util.Log
import com.example.cnnapp.common.Constants
import com.example.cnnapp.common.enqueue
import com.example.cnnapp.network.ClientInterface
import com.example.cnnapp.network.RetrofitInstance

class PresenterImp (_view: ViewInterface?): PresenterInterface {

    var view: ViewInterface? = _view

    override fun processCall() {

        val clientInterface =
            RetrofitInstance().retrofitInstance.create(ClientInterface::class.java)

        val call = clientInterface.getNewsRecords(Constants.COUNTRY, Constants.API_KEY)

        // this is the extension function version of the callback enqueue

        call.enqueue {
            onResponse = {

                newsModel -> val newsModelRecords = newsModel.body()

                view?.onShowList(newsModelRecords!!)
            }
            onFailure = {
                    error -> Log.d("Failure", error?.message)
            }

        }
    }

    override fun onDestroy() {
        view = null
    }

}
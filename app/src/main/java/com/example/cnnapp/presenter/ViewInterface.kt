package com.example.cnnapp.presenter

import com.example.cnnapp.model.CnnModel

interface ViewInterface {

    fun showProgress()
    fun showError()
    fun onShowList(cnnModel: CnnModel)
}
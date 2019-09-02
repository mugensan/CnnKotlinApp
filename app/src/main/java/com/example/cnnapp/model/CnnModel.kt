package com.example.cnnapp.model


import com.google.gson.annotations.SerializedName

data class CnnModel (

	@SerializedName("status") val status : String,
	@SerializedName("totalResults") val totalResults : Int,
	@SerializedName("articles") val articles : List<Articles>
)
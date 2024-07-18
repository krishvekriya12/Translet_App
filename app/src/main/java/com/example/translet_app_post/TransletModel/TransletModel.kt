package com.example.translet_app_post.TransletModel

import com.google.gson.annotations.SerializedName

data class TransletModel(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class Data(

	@field:SerializedName("translatedText")
	val translatedText: String? = null
)

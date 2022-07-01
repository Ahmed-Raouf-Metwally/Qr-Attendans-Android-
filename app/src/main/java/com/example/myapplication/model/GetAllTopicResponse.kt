package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class GetAllTopicResponse(

	@field:SerializedName("Topics")
	val topics: List<TopicsItem?>? = null
)

data class TopicsItem(

	@field:SerializedName("Mat_ref")
	val matRef: String? = null,

	@field:SerializedName("Discption")
	val discption: String? = null,

	@field:SerializedName("ID")
	val iD: String? = null,

	@field:SerializedName("Name")
	val name: String? = null
)

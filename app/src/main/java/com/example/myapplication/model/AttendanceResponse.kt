package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class AttendanceResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("Attend_Student")
	val attendStudent: List<AttendStudentItem?>? = null
)

data class AttendStudentItem(

	@field:SerializedName("__v")
	val V: Int? = null,

	@field:SerializedName("ID")
	val iD: Int? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("Topic")
	val topic: Int? = null,

	@field:SerializedName("Matrial")
	val matrial: Int? = null,

	@field:SerializedName("Name")
	val name: String? = null
)

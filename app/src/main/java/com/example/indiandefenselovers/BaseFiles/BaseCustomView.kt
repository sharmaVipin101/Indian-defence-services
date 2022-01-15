package com.example.indiandefenselovers.BaseFiles

import com.google.gson.annotations.SerializedName

data class BaseCustomView(
    @SerializedName("user") val user:User
)

data class User(
    @SerializedName("user_name") val name: String?,
    @SerializedName("user_email") val email: String?,
    @SerializedName("user_mobile") val mobile: String?,
    @SerializedName("user_image") val image: String?,
    @SerializedName("user_about") val description: String?,
    @SerializedName("mentored") val mentored: Int?,
    @SerializedName("fee") val fee: Fees?,
    @SerializedName("social") val social: Social?,
)

data class Fees(
    @SerializedName("half_hour") val halfHour: Double?,
    @SerializedName("one_hour") val oneHour: Double?,
    @SerializedName("paper_strategy_plan") val writtenPlan: Double?,
    @SerializedName("ssb_strategy_plan") val ssbPlan: Double?,
    @SerializedName("individual_subject_plan") val eachPaper: Double?,
)

data class Social(
    @SerializedName("instagram") val insta: String?,
    @SerializedName("youtube") val youtube: String?
)
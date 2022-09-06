package dev.kishoiyan.workoutlog.models

import com.google.gson.annotations.SerializedName

data class LogInResponse (
    var message:String,
    @SerializedName("accessToken")var accessToken:String,
    @SerializedName("userId")var userId:String,
    @SerializedName("profileId")var profileId:String
)

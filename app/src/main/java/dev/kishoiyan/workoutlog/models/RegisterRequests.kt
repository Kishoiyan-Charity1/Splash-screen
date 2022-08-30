package dev.kishoiyan.workoutlog.models

import com.google.gson.annotations.SerializedName

class RegisterRequests (
    @SerializedName ("first_name")var firstname:String,
    @SerializedName ("last_name")var lastname:String,
    var email:String,
    @SerializedName("phone_number")var phonenumber:String,
    var password:String

)
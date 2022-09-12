package dev.kishoiyan.workoutlog.models

data class RegisterResponse(
    var message:String,
    var user:User,
    var firstname:String,
    var lastname:String,
    var phonenumber:String
)
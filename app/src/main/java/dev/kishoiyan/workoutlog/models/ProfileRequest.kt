package dev.kishoiyan.workoutlog.models

data class ProfileRequest (
    var userId:String,
    var sex : String,
    var weight : Int,
    var height : Int,
    var dateofbirth : String

)

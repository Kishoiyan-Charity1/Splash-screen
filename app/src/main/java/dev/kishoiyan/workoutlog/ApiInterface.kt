package dev.kishoiyan.workoutlog

import dev.kishoiyan.workoutlog.models.LogInRequest
import dev.kishoiyan.workoutlog.models.LogInResponse
import dev.kishoiyan.workoutlog.models.RegisterRequests
import dev.kishoiyan.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("/register")
    fun registerUser(@Body registerRequests: RegisterRequests): Call<RegisterResponse>

    @POST("/login")
    fun loginUser(@Body logInRequest: LogInRequest):Call<LogInResponse>
}
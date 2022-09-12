package dev.kishoiyan.workoutlog

import dev.kishoiyan.workoutlog.models.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("/register")
    fun registerUser(@Body registerRequests: RegisterRequests): Call<RegisterResponse>

    @POST("/login")
    suspend fun loginUser(@Body logInRequest: LogInRequest):Response<LogInResponse>

    @POST("/profile")
    suspend fun userProfile(@Body profileRequest: ProfileRequest): Call<ProfileResponse>
}
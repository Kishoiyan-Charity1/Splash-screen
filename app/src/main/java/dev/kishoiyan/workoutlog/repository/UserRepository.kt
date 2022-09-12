package dev.kishoiyan.workoutlog.repository

import dev.kishoiyan.workoutlog.ApiClient
import dev.kishoiyan.workoutlog.ApiInterface
import dev.kishoiyan.workoutlog.models.LogInRequest
import dev.kishoiyan.workoutlog.models.LogInResponse
import dev.kishoiyan.workoutlog.models.RegisterRequests
import dev.kishoiyan.workoutlog.models.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response

class UserRepository {
    val apiClient= ApiClient.buildApiClient(ApiInterface::class.java)


    suspend fun loginUser(logInRequest: LogInRequest): Response<LogInResponse>
    = withContext(Dispatchers.IO){

        val response=apiClient.loginUser(logInRequest)
        return@withContext response
    }
    suspend fun registerUser(registerRequests: RegisterRequests): Call<RegisterResponse>
    = withContext(Dispatchers.IO){
        val response= apiClient.registerUser(registerRequests)
        return@withContext response
    }
}
package dev.kishoiyan.workoutlog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.kishoiyan.workoutlog.models.LogInRequest
import dev.kishoiyan.workoutlog.models.LogInResponse
import dev.kishoiyan.workoutlog.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel(){
    val userRepository= UserRepository()
    val loginLiveData= MutableLiveData<LogInResponse>()
    val loginError = MutableLiveData<String>()

     fun login(loginRequest:LogInRequest){
        viewModelScope.launch {
            val response= userRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                loginLiveData.postValue(response.body())
            }
            else{
                loginError.postValue(response.errorBody()?.string())
            }
        }
    }
}
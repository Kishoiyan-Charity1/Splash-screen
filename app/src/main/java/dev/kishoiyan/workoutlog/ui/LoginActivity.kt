package dev.kishoiyan.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.kishoiyan.workoutlog.ApiClient
import dev.kishoiyan.workoutlog.ApiInterface
import dev.kishoiyan.workoutlog.databinding.ActivityLoginBinding
import dev.kishoiyan.workoutlog.models.LogInRequest
import dev.kishoiyan.workoutlog.models.LogInResponse
import dev.kishoiyan.workoutlog.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPrefs:SharedPreferences
    val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.tvSignup.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

        }
        binding.btnLogIn.setOnClickListener {
            validateLogIn()

        }

    }

    override fun onResume() {
        super.onResume()
        userViewModel.loginLiveData.observe(this, Observer{ loginResponse->
            Toast.makeText(baseContext, loginResponse?.message,Toast.LENGTH_LONG).show()
            persistLogInDetails(loginResponse!!)
            startActivity(Intent(baseContext,HomeActivity::class.java))

        })

        userViewModel.loginError.observe(this) { errorMsg ->
            Toast.makeText(baseContext, errorMsg, Toast.LENGTH_LONG).show()
        }
    }

    fun validateLogIn(){
            var email = binding.etEmail.text.toString()
            var password = binding.etPassword.text.toString()
            var error=false

            if (email.isBlank()){
                error=true
                binding.tilEmail.error = "Email is required"
            }
            if (password.isBlank()){
                error=true
                binding.tilPassword.error = "password is required"
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.tilEmail.error="enter email"
            }
            if (!error){
                val loginRequest= LogInRequest(email, password)
                userViewModel.login(loginRequest)
            }


        }


    fun persistLogInDetails(logInResponse: LogInResponse){
        val editor=sharedPrefs.edit()
        editor.putString("USER_ID",logInResponse.userId)
        editor.putString("ACCESS_TOKEN",logInResponse.accessToken)
        editor.putString("PROFILE_ID",logInResponse.profileId)
        editor.apply()
    }

}
package dev.kishoiyan.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import dev.kishoiyan.workoutlog.ApiClient
import dev.kishoiyan.workoutlog.ApiInterface
import dev.kishoiyan.workoutlog.databinding.ActivityLoginBinding
import dev.kishoiyan.workoutlog.models.LogInRequest
import dev.kishoiyan.workoutlog.models.LogInResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPrefs:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogIn.setOnClickListener {
            validateLogIn()
        }

    }
        fun validateLogIn(){
            var email = binding.etEmail.text.toString()
            var password = binding.etPassword.text.toString()
            if (email.isBlank()){
                binding.tilEmail.error = "Email is required"

            }
            if (password.isBlank()){
                binding.tilPassword.error = "password is required"
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.tilEmail.error="enter email"
            }


        }
    fun makeLoginRequest(logInRequest: LogInRequest){
        val apiClient= ApiClient.buildApiClient(ApiInterface::class.java)
        val request=apiClient.loginUser(logInRequest)

        request.enqueue(object :Callback<LogInResponse>{
            override fun onResponse(call: Call<LogInResponse>, response: Response<LogInResponse>) {
                if (response.isSuccessful){
                    val logInResponse=response.body()
                    Toast.makeText(
                        baseContext,logInResponse?.message,
                        Toast.LENGTH_LONG
                    ).show()
                }

            }

            override fun onFailure(call: Call<LogInResponse>, t: Throwable) {
               Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }


        })
    }
    fun persistLogInDetails(logInResponse: LogInResponse){
        val editor=sharedPrefs.edit()
        editor.putString("USER_ID",logInResponse.userId)
        editor.putString("ACCESS_TOKEN",logInResponse.accessToken)
        editor.putString("PROFILE_ID",logInResponse.profileId)
        editor.apply()
    }

}
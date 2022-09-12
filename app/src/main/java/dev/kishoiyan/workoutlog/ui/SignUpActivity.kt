package dev.kishoiyan.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import dev.kishoiyan.workoutlog.ApiClient
import dev.kishoiyan.workoutlog.ApiInterface
import dev.kishoiyan.workoutlog.databinding.ActivitySignUpBinding
import dev.kishoiyan.workoutlog.models.LogInResponse
import dev.kishoiyan.workoutlog.models.RegisterRequests
import dev.kishoiyan.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvLogIn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            validateLogIn()

        }
    }

     fun validateLogIn() {
        var firstname = binding.etFirstName.text.toString()
        var lastname = binding.etLastName.text.toString()
        var email = binding.etEmail.text.toString()
        var password = binding.etPassword.text.toString()
        var confirm = binding.etConfirm.text.toString()
        var phoneNumber = binding.etPhoneNumber.text.toString()


        var error = false

        if (firstname.isBlank()) {
            error = true
            binding.tilFirstName.error = "Enter Name"
        }
        if (lastname.isBlank()) {
            binding.tilLastName.error = "Enter Last Name"
        }
        if (email.isBlank()) {
            error = true
            binding.tilEmail.error = "Enter Email"
        }
        if (password.isBlank()) {
            error = true
            binding.tilPassword.error = "Enter Password"
        }
        if (confirm.isBlank()) {
            error = true
            binding.tilConfirm.error = "Confirm"
        }
        if (!password.equals(confirm)) {
            error = true
            binding.tilPassword.error = "wrong password"
        }
        if (phoneNumber.isBlank()) {
            error = true
            binding.tilPhoneNumber.error = "Enter PhoneNUmber"
        }
        if (!error) {
            binding.pbRegister.visibility = View.VISIBLE
            var registerRequests =
                RegisterRequests(firstname, lastname, email, password, confirm, phoneNumber)
            makeRegistrationRequest(registerRequests)
        }
    }

     fun makeRegistrationRequest(registerRequests: RegisterRequests) {
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.registerUser(registerRequests)

        request.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {

                binding.pbRegister.visibility = View.GONE
                if (response.isSuccessful) {
                    var message = response.body()?.message

                    Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
                } else {
                    var error = response.errorBody()?.string()
                    Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

        })

    }
}
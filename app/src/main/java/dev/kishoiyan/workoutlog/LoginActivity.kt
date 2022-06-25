package dev.kishoiyan.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.kishoiyan.workoutlog.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.tvSignup.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)

        }
        binding.btnLogIn.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

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

        }
}
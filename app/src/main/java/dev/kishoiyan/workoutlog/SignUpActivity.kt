package dev.kishoiyan.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.kishoiyan.workoutlog.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
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
    fun validateLogIn(){
        var firstname= binding.etFirstName.text.toString()
        var lastname= binding.etLastName.text.toString()
        var email= binding.etEmail.text.toString()
        var password= binding.etPassword.toString()
        var confirm= binding.etConfirm.toString()
        if (firstname.isBlank()){
            binding.tilFirstName.error= "Enter Name"
        }

        if (lastname.isBlank()){
            binding.tilLastName.error="Enter Last Name"
        }
        if (email.isBlank()){
            binding.tilEmail.error="Enter Email"
        }
        if (password.isBlank()){
            binding.tilPassword.error="Enter Password"
        }
        if (confirm.isBlank()){
            binding.tilConfirm.error="Confirm"
        }
    }

}
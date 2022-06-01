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

class SignUpActivity : AppCompatActivity() {
    lateinit var etFirstName: TextInputEditText
    lateinit var etLastName: TextInputEditText
    lateinit var etEmail: TextInputEditText
    lateinit var etPassword: TextInputEditText
    lateinit var etConfirm: TextInputEditText
    lateinit var btnSignUp: Button
    lateinit var  tvLogIn: TextView
    lateinit var tilFirstName: TextInputLayout
    lateinit var tilLastName: TextInputLayout
    lateinit var tilEmail: TextInputLayout
    lateinit var tilPassword: TextInputLayout
    lateinit var tilConfirm: TextInputLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

       etFirstName= findViewById(R.id.etFirstName)
        etLastName= findViewById(R.id.etLastName)
        etEmail= findViewById(R.id.etEmail)
        etPassword= findViewById(R.id.etPassword)
        etConfirm= findViewById(R.id.etConfirm)
        btnSignUp= findViewById(R.id.btnSignUp)
        tvLogIn= findViewById(R.id.tvLogIn)
        tilFirstName = findViewById(R.id.tilFirstName)
        tilLastName = findViewById(R.id.tilLastName)
        tilEmail= findViewById(R.id.tilEmail)
        tilPassword= findViewById(R.id.tilPassword)
        tilConfirm= findViewById(R.id.tilConfirm)

        tvLogIn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

            validateSignUp()
        }


    }
    fun validateSignUp(){
        var firstname= etFirstName.text.toString()
        var lastname= etLastName.text.toString()
        var email= etEmail.text.toString()
        var password= etPassword.toString()
        var confirm= etConfirm.toString()
        if (firstname.isBlank()){
            tilFirstName.error= "Enter Name"
        }

        if (lastname.isBlank()){
            tilLastName.error="Enter Last Name"
        }
        if (email.isBlank()){
            tilEmail.error="Enter Email"
        }
        if (password.isBlank()){
            tilPassword.error="Enter Password"
        }
        if (confirm.isBlank()){
            tilConfirm.error="Confirm"
        }
    }

}
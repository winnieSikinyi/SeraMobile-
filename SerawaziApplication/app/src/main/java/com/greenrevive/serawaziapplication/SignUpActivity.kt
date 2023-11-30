//package com.greenrevive.serawaziapplication
//
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.text.Editable
//import android.text.TextWatcher
//import android.widget.Toast
//import androidx.activity.viewModels
//import androidx.lifecycle.Observer
//import com.greenrevive.serawaziapplication.databinding.ActivitySignUpBinding
//import com.greenrevive.serawaziapplication.model.RegisterRequest
//import com.greenrevive.serawaziapplication.viewmodel.UserViewModel
//
//class SignUpActivity: AppCompatActivity() {
//    private lateinit var binding: ActivitySignUpBinding
//    val userViewModel: UserViewModel by viewModels()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivitySignUpBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.tvLogin.setOnClickListener {
//            val intent = Intent(this, LogIn::class.java)
//            startActivity(intent)
//        }
//    }
//    override fun onResume() {
//        super.onResume()
//        binding.btnSignup.setOnClickListener {
//            clearErrors()
//            validateSignUp()
//        }
//        binding.tvLogin.setOnClickListener {
//            val intent = Intent(this, LogIn::class.java)
//            startActivity(intent)
//            finish()
//        }
//
//        userViewModel.regLiveData.observe(this, Observer { regResponse ->
//            Toast.makeText(this,regResponse.message,Toast.LENGTH_LONG).show()
//            val intent =Intent(this,LogIn::class.java)
//            startActivity(intent)
//            finish()
//        })
//        binding.etFullName.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//                clearErrors()
//            }
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//            }
//        })
//        binding.etEmails.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//                clearErrors()
//            }
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//            }
//        })
//        binding.etPasswords.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//                clearErrors()
//            }
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//            }
//        })
//        binding.etConfirmPassword.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//                clearErrors()
//            }
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//            }
//        })
//        binding.etPhoneNumber.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//                clearErrors()
//            }
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//            }
//        })
//    }
//    fun validateSignUp() {
//        val fullName = binding.etFullName.text.toString()
//        val email = binding.etEmails.text.toString()
//        val password = binding.etPasswords.text.toString()
//        val passwordConfirm = binding.etConfirmPassword.text.toString()
//        val phoneNumber = binding.etPhoneNumber.text.toString()
//        var error = false
//        if (fullName.isBlank()) {
//            binding.tilFullName.error = "Enter name"
//            error = true
//        }
//        if (email.isBlank()) {
//            binding.tilEmails.error = "Email is required"
//            error = true
//        }
//        if(phoneNumber.isBlank()){
//            binding.tilPhoneNumber.error = "phone number required"
//            error = true
//        }
//        if (password.isBlank()) {
//            binding.tilPasswords.error = "Password is required"
//            error = true
//        }
//        if (passwordConfirm != password) {
//            binding.tilConfirmPassword.error = "Confirm your password"
//            error = true
//        }
//        if (!error) {
//            val registerRequest = RegisterRequest(
//                fullName = fullName,
//                email = email,
//                password = password,
//                passwordConfirm = passwordConfirm,
//                phoneNumber = phoneNumber,
//            )
//            
//        }
//    }
//    fun clearErrors() {
//        binding.tilFullName.error = null
//        binding.tilEmails.error = null
//        binding.tilPasswords.error = null
//        binding.tilConfirmPassword.error = null
//        binding.tilPhoneNumber.error = null
//    }
//
//}
//
//

package com.greenrevive.serawaziapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.greenrevive.serawaziapplication.databinding.ActivitySignUpBinding
import com.greenrevive.serawaziapplication.model.RegisterRequest
import com.greenrevive.serawaziapplication.viewmodel.UserViewModel

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.btnSignup.setOnClickListener {
            clearErrors()
            validateSignUp()
        }
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
            finish()
        }

        userViewModel.regLiveData.observe(this, Observer { regResponse ->
            Toast.makeText(this, regResponse.message, Toast.LENGTH_LONG).show()
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
            finish()
        })

        binding.etFullName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                clearErrors()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        binding.etEmails.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                clearErrors()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        binding.etPasswords.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                clearErrors()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        binding.etConfirmPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                clearErrors()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        binding.etPhoneNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                clearErrors()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun validateSignUp() {
        val fullName = binding.etFullName.text.toString()
        val email = binding.etEmails.text.toString()
        val password = binding.etPasswords.text.toString()
        val passwordConfirm = binding.etConfirmPassword.text.toString()
        val phoneNumber = binding.etPhoneNumber.text.toString()
        var error = false

        if (fullName.isBlank()) {
            binding.tilFullName.error = "Enter name"
            error = true
        }

        if (email.isBlank()) {
            binding.tilEmails.error = "Email is required"
            error = true
        }

        if (phoneNumber.isBlank()) {
            binding.tilPhoneNumber.error = "Phone number required"
            error = true
        }

        if (password.isBlank()) {
            binding.tilPasswords.error = "Password is required"
            error = true
        }

        if (passwordConfirm != password) {
            binding.tilConfirmPassword.error = "Confirm your password"
            error = true
        }
        if (passwordConfirm.isBlank()) {
            binding.tilConfirmPassword.error = "Confirm your password"
            error = true
        }

        if (!error) {
            val registerRequest = RegisterRequest(
                fullName = fullName,
                email = email,
                password = password,
                passwordConfirm = passwordConfirm,
                phoneNumber = phoneNumber,
            )

            binding.btnSignup.setOnClickListener {
                Toast.makeText(this, "Successfully Registered !!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LogIn::class.java)
                    startActivity(intent)
                }


//            userViewModel.registerUser(registerRequest)

            // Save the entered username and password
//            saveUserData(email, password)
        }
    }

//    private fun saveUserData(userName: String, password: String) {
//        val editor = getSharedPreferences("user_data", Context.MODE_PRIVATE).edit()
//        editor.putString("userName", userName)
//        editor.putString("password", password)
//        editor.apply()
//    }

    private fun clearErrors() {
        binding.tilFullName.error = null
        binding.tilEmails.error = null
        binding.tilPasswords.error = null
        binding.tilConfirmPassword.error = null
        binding.tilPhoneNumber.error = null
    }
}

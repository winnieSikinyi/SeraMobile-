package com.greenrevive.serawaziapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.greenrevive.serawaziapplication.databinding.ActivityLogInBinding
import com.greenrevive.serawaziapplication.model.LoginRequest
import com.greenrevive.serawaziapplication.viewmodel.LoginViewModel

class LogIn : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    private val loginUserViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        binding.btnSignin.setOnClickListener {
            validateLogin()

        }

        loginUserViewModel.errLiveData.observe(this) { err ->
            Toast.makeText(this, err, Toast.LENGTH_LONG).show()
            binding.pbLogin.visibility = View.GONE
        }
        loginUserViewModel.regLiveData.observe(this, Observer { loginResponse ->
            Toast.makeText(this, loginResponse.message, Toast.LENGTH_LONG).show()
            binding.pbLogin.visibility = View.GONE
            val intent = Intent(this, AnswerChat::class.java)
            startActivity(intent)
            finish()
        })

        binding.tvNotMember.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.etUserName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                clearErrors()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        binding.etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                clearErrors()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }
    private fun validateLogin() {
    val userName = binding.etUserName.text.toString()
    val password = binding.etPassword.text.toString()
    var error = false
    if (userName.isBlank()) {
        binding.tilUserName.error = "Enter your UserName"
        error = true
    }
    if (password.isBlank()) {
        binding.tilPassword.error = "Enter your Password"
        error = true
    }
    if (!error) {
        val loginRequest = LoginRequest(
            password = password,
            userName = userName,

        )

        binding.pbLogin.visibility = View.VISIBLE
        val intent = Intent(this, AnswerChat::class.java)
        startActivity(intent)
        finish()
        loginUserViewModel.Login(loginRequest)


      
    }
      

}




    private fun clearErrors() {
        binding.tilUserName.error = null
        binding.tilPassword.error = null


    }

}


package com.greenrevive.serawaziapplication

import android.content.Context
import androidx.appcompat.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.greenrevive.serawaziapplication.databinding.ActivityChatbotInteractionBinding


//class ChatbotInteraction : AppCompatActivity() {
//    private lateinit var binding: ActivityChatbotInteractionBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityChatbotInteractionBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//    }
//    
//    override fun onResume() {
//        super.onResume()
//        binding.imageView5.setOnClickListener {
//            val popupView = layoutInflater.inflate(R.layout.popup_layout, null)
//            val alertDialog = AlertDialog.Builder(this).create()
//            alertDialog.setView(popupView)
//            val closeButton = popupView.findViewById<Button>(R.id.closePopupButton)
//            closeButton.setOnClickListener {
//                alertDialog.dismiss()
//                val intent = Intent(this, SignUpActivity::class.java)
//                startActivity(intent)
//            }
//            alertDialog.show()
//        }
//
//    }
//}
class ChatbotInteraction : AppCompatActivity() {
    private lateinit var binding: ActivityChatbotInteractionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatbotInteractionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (isLoggedInOrSignedUp()) {
            navigateToTargetScreen()
            finish()
        }
    }

    override fun onResume() {
        super.onResume()

        binding.imageView5.setOnClickListener {
            if (isLoggedInOrSignedUp()) {
                navigateToTargetScreen()
                finish() // Finish this activity to prevent going back to it when the user presses back from the target screen
            } else {
                showSignUpPopup()
            }
        }
    }

    private fun showSignUpPopup() {
        val popupView = layoutInflater.inflate(R.layout.popup_layout, null)
        val alertDialog = AlertDialog.Builder(this).create()
        alertDialog.setView(popupView)
        val closeButton = popupView.findViewById<Button>(R.id.closePopupButton)
        closeButton.setOnClickListener {
            alertDialog.dismiss()
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        alertDialog.show()
    }

    private fun navigateToTargetScreen() {
        val intent = Intent(this, AnswerChat::class.java)
        startActivity(intent)
    }

    private fun isLoggedInOrSignedUp(): Boolean {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("isLoggedInOrSignedUp", false)
    }
}
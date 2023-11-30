package com.greenrevive.serawaziapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.greenrevive.serawaziapplication.databinding.ActivityHomepageBinding

class homepage : AppCompatActivity() {
    lateinit var binding: ActivityHomepageBinding
    private var billsButtonClicked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }



    override fun onResume() {
        super.onResume()
        setupBottomNav()

    }

    fun setupBottomNav() {
        binding.bnvHome.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.home -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fcvHome, HomeFragment())
                        .commit()

                    true
                }
                R.id.settings -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fcvHome, SettingsFragment())
                        .commit()

                    true
                }
                R.id.profile-> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fcvHome,ProfileFragment())
                        .commit()

                    true
                }

                R.id.level-> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fcvHome,LevelSelectionFragment())
                        .commit()

                    true
                }

                else ->false
            }
        }
    }
}
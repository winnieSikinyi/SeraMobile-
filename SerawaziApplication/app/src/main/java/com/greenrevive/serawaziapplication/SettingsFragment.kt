package com.greenrevive.serawaziapplication



import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.greenrevive.serawaziapplication.databinding.FragmentSettingsBinding
import com.greenrevive.serawaziapplication.utils.Constants

class SettingsFragment : Fragment() {
     var binding: FragmentSettingsBinding? = null

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//<<<<<<< HEAD
//        return inflater.inflate(R.layout.fragment_settings, container, false)
//=======
   binding = FragmentSettingsBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onResume() {
        super.onResume()
//        binding?.tvappversion?. text ="APP VERSION : ${com.greenrevive.serawaziapplication.Buildconfig.VERSION_NAME}"

        binding?.tvlogout?.setOnClickListener{logout()}

    }

    fun logout(){
        val sharedPrefs =requireContext(). getSharedPreferences(Constants.PREFS, Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        editor.putString(Constants.USER_ID, Constants.EMPTY_STRING)
        editor.putString(Constants.ACCESS_TOKEN,Constants.EMPTY_STRING)
        editor.apply()
        requireContext().startActivity(Intent(requireContext() ,LogIn::class.java))
    }

    override fun onDestroy() {
        super.onDestroy()
        binding =null
    }
}

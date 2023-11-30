package com.greenrevive.serawaziapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
//import androidx.navigation.fragment.findNavController
import com.greenrevive.serawaziapplication.databinding.FragmentHomeBinding
import com.greenrevive.serawaziapplication.ui.SelectALevelActivity


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var billsButtonClicked = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButtonClickListeners()
    }

    private fun setupButtonClickListeners() {
        binding.btnBills.setOnClickListener {
            val playButton = binding.btnplay
            playButton.elevation = resources.getDimension(R.dimen.increased_shadow_radius)
            playButton.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.greenColor))
            playButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.whiteColor))
            binding.btnBills.elevation = resources.getDimension(R.dimen.increased_shadow_radius)
            billsButtonClicked = true
        }


        binding.btnfinance.setOnClickListener {
            val playButton = binding.btnplay
            playButton.elevation = resources.getDimension(R.dimen.increased_shadow_radius)
            playButton.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.whiteColor))
            playButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.greenColor))
            binding.btnfinance.elevation = resources.getDimension(R.dimen.increased_shadow_radius)
            Toast.makeText(requireContext(), "Coming Soon!!", Toast.LENGTH_SHORT).show()
//            billsButtonClicked = true
        }
//        val button = view?.findViewById<Button>(R.id.btnplay)

        binding.btnplay.setOnClickListener {
            if (billsButtonClicked) {
//                requireContext().startActivity(Intent(requireContext() ,com.greenrevive.serawaziapplication.LevelSelectionFragment::class.java))
                val intent = Intent(requireContext(), SelectALevelActivity::class.java)
                startActivity(intent)
//                val navController = findNavController()
//                navController.navigate(R.id.level)

            }
        }
    }
}

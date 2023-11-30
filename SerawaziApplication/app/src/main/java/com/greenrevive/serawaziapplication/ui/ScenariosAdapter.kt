//package com.greenrevive.serawaziapplication.ui
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.greenrevive.serawaziapplication.databinding.ActivityLevelpurpleBinding
//import com.greenrevive.serawaziapplication.model.ScenarioDataClass
//
//
//class ScenariosAdapter(private val scenarios: List<ScenarioDataClass>, private val onClick: (ScenarioDataClass) -> Unit) : RecyclerView.Adapter<ScenariosAdapter.ScenarioViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScenarioViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val binding = ActivityLevelpurpleBinding.inflate(layoutInflater, parent, false)
//        return ScenarioViewHolder(binding)
//    }
//    override fun onBindViewHolder(holder: ScenarioViewHolder, position: Int) {
//        val scenario = scenarios[position]
//        holder.bind(scenario)
//    }
//    override fun getItemCount(): Int {
//        return scenarios.size
//    }
//}
//
//class ScenarioViewHolder(private val binding: ActivityLevelpurpleBinding) : RecyclerView.ViewHolder(binding.root) {
//    fun bind(scenario: ScenarioDataClass) {
//        // Bind scenario data to the item view
////        binding.scenario = scenario
////        binding.executePendingBindings()
////        itemView.setOnClickListener { onClick(scenario) }
//    }
//}
//

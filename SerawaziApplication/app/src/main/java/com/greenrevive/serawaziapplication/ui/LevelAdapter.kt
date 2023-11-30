package com.greenrevive.serawaziapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.greenrevive.serawaziapplication.R
import com.greenrevive.serawaziapplication.model.Levels

class LevelAdapter(
    private val levels: List<Levels>,
    private val onItemClick: (Levels) -> Unit
) : RecyclerView.Adapter<LevelAdapter.LevelsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_levelpurple, parent, false)
        return LevelsViewHolder(view)
    }

    override fun onBindViewHolder(holder: LevelsViewHolder, position: Int) {
        val level = levels[position]
        holder.bind(level)
        holder.itemView.setOnClickListener { onItemClick(level) }
    }

    override fun getItemCount(): Int {
        return levels.size
    }

    inner class LevelsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val levelTitleTextView: TextView = itemView.findViewById(R.id.cdQ2)

        fun bind(level: Levels) {
            levelTitleTextView.text = level.levelTitle
        }
    }
}








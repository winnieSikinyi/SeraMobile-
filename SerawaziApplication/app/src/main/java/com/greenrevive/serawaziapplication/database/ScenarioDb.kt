//package com.greenrevive.serawaziapplication.database

import LevelsDao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.greenrevive.serawaziapplication.database.ScenarioDao
import com.greenrevive.serawaziapplication.model.Levels
import com.greenrevive.serawaziapplication.model.ScenarioDataClass


@Database(entities = [Levels::class, ScenarioDataClass::class], version = 2, exportSchema = false)
abstract class ScenarioDb : RoomDatabase() {

    abstract fun getScenarioDao(): ScenarioDao
    abstract fun getLevelsDao(): LevelsDao

    companion object {
        private var database: ScenarioDb? = null

        fun getDatabase(context: Context): ScenarioDb {
            if (database == null) {
                database = Room.databaseBuilder(
                    context.applicationContext,
                    ScenarioDb::class.java,
                    "ScenarioDb"
                ).fallbackToDestructiveMigration().build()
            }
            return database as ScenarioDb
        }
    }
}

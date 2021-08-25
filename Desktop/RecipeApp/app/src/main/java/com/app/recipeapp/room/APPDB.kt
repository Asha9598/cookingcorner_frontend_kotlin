package com.app.recipeapp.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class APPDB : RoomDatabase() {

    abstract fun getUserDAO(): UserDAO

    companion object {
        @Volatile
        private var Instance: APPDB? = null;
        fun getInstance(context: Context): APPDB {
            if (Instance == null) {
                synchronized(APPDB::class.java) {
                    Instance = buildDatabase(context);

                }
            }
            return Instance!!;
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                APPDB::class.java,
                "db_cookingCorner"
            ).fallbackToDestructiveMigration()
                .build();

    }
}
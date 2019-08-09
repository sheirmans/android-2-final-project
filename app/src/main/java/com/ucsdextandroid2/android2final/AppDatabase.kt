package com.ucsdextandroid2.android2final

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.Job


/**
 * Created by rjaylward on 2019-07-05
 */

@Database(entities = [Job::class],version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun jobDao(): JobDao

    companion object {

        private const val DB_NAME = "jobapp.db"

        @Volatile private var INSTANCE: AppDatabase? = null

        @JvmStatic
        fun get(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }


        private fun buildDatabase(context: Context): AppDatabase {
            return Room
                    .databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                    .allowMainThreadQueries()  //addd to avoid slowness
                    .build()

        }
    }

}

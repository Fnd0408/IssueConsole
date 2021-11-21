package com.forfun.IssueConsole.localdata.db

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.forfun.IssueConsole.localdata.dao.LocalEventDAO
import com.forfun.IssueConsole.localdata.model.Event


@Database(entities = [Event::class], version = 1)
abstract class EventDatabase : RoomDatabase() {
    abstract val eventDao: LocalEventDAO?

    override fun createOpenHelper(config: DatabaseConfiguration): SupportSQLiteOpenHelper {
        TODO("Not yet implemented")
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun clearAllTables() {}

    companion object {
        private const val DB_NAME = "EventDatabase.db"

        @Volatile
        private var instance: EventDatabase? = null

        @Synchronized
        fun getInstance(context: Context): EventDatabase? {
            if (instance == null) {
                instance = create(context)
            }
            return instance
        }

        private fun create(context: Context): EventDatabase {
            return Room.databaseBuilder(
                context,
                EventDatabase::class.java,
                DB_NAME
            ).build()
        }
    }
}
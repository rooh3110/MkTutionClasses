package sanaebadi.info.teacherhandler.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BatchTime::class], version = 1)
abstract class BatchTimeRoomDatabase : RoomDatabase() {

    abstract fun batchTimeDao(): BatchTimeDao

    companion object {
        private var sInstance: BatchTimeRoomDatabase? = null


        fun getDatabase(context: Context): BatchTimeRoomDatabase {
            if (BatchTimeRoomDatabase.sInstance == null) {
                synchronized(RoomDatabase::class.java) {
                    if (BatchTimeRoomDatabase.sInstance == null) {
                        BatchTimeRoomDatabase.sInstance = Room.databaseBuilder(
                            context.applicationContext,
                            BatchTimeRoomDatabase::class.java, "time_batch_db"
                        ).build()
                    }
                }
            }

            return BatchTimeRoomDatabase.sInstance!!
        }
    }
}
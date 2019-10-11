package myapp.mahindra.com.myapplication.utils

import android.content.Context
import androidx.room.Room

class DatabaseClient private constructor(private val mCtx: Context) {

    //our app database object
    val appDatabase: AppDatabase

    init {

        //creating the app database with Room database builder
        //MyToDos is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase::class.java, "MyToDos").build()
    }

    companion object {
        private var mInstance: DatabaseClient? = null

        @Synchronized
        fun getInstance(mCtx: Context): DatabaseClient {
            if (mInstance == null) {
                mInstance = DatabaseClient(mCtx)
            }
            return mInstance as DatabaseClient
        }
    }
}
package myapp.mahindra.com.myapplication.utils

import androidx.room.*

@Dao
public interface MovieDeo {

    @Query("SELECT * FROM MovieInfo")
    abstract fun getAll(): List<MovieInfo>

    @Insert
    abstract fun insert(myInfo: MovieInfo)

    @Delete
    abstract fun delete(myInfo: MovieInfo)

    @Update
    abstract fun update(myInfo: MovieInfo)
}
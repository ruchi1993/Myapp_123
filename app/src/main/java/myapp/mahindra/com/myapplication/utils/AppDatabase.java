package myapp.mahindra.com.myapplication.utils;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {MovieInfo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MovieDeo taskDao();
}

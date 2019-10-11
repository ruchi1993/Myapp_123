package myapp.mahindra.com.myapplication.utils

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class MovieInfo :Serializable{

    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0

    @ColumnInfo(name = "Title")
    private var Title: String? = null

    @ColumnInfo(name = "Year")
    private var Year: String? = null

    @ColumnInfo(name = "Type")
    private var Type: String? = null



}
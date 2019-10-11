package myapp.mahindra.com.myapplication.utils

import com.google.gson.annotations.SerializedName
import java.util.*

class MovieResponse {

    @SerializedName("Search")
    var Search: ArrayList<MovieInput>? = null

    @SerializedName("totalResults")
    var status: String? = null

    @SerializedName("Response")
    var Response: String? = null


}
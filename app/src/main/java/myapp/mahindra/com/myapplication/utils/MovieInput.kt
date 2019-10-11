package myapp.mahindra.com.myapplication.utils

import com.google.gson.annotations.SerializedName

class MovieInput {


    @SerializedName("Title")
    var Title: String? = null

    @SerializedName("Year")
    var Year: String? = null

    @SerializedName("imdbID")
    var imdbID: String? = null

    @SerializedName("Type")
    var Type: String? = null

    @SerializedName("Poster")
    var Poster: String? = null
}
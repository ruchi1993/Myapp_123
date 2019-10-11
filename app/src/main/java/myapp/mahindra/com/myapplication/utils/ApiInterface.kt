package myapp.mahindra.com.myapplication.utils



import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

public interface ApiInterface {


    @GET("?i=tt3896198&apikey=4b353481&s=Batman&page=1")
    abstract fun getMoviesDetails(): Call<MovieResponse>

    companion object Factory {


        val BASE_URL = "http://www.omdbapi.com/"

        fun create(): ApiInterface {


            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiInterface::class.java);


        }
    }
}
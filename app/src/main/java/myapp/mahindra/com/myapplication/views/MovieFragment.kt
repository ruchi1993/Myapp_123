package myapp.mahindra.com.myapplication.views

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movie.view.*
import kotlinx.android.synthetic.main.movie_items.view.*
import myapp.mahindra.com.myapplication.R
import myapp.mahindra.com.myapplication.model.Movie
import myapp.mahindra.com.myapplication.utils.ApiInterface
import myapp.mahindra.com.myapplication.utils.MovieInput
import myapp.mahindra.com.myapplication.utils.MovieResponse
import retrofit2.Call
import retrofit2.Callback


class MovieFragment  : Fragment() {
    var adapter: MovieAdpater? = null
    var foodsList = ArrayList<Movie>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.fragment_movie, container, false)

        DisplayProgressDialog()
        val apiService = ApiInterface.create()


        val call = apiService.getMoviesDetails()
        Log.d("REQUEST", call.toString() + "")
        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: retrofit2.Response<MovieResponse>?) {
                if (response != null) {
                    if (pDialog != null && pDialog!!.isShowing()) {
                        pDialog.dismiss()
                    }

                    var list: ArrayList<MovieInput> = response.body().Search!!
                    Log.d("LIST:-", "" + list.size)

                    for (item: MovieInput in list.iterator()) {

                        adapter = MovieAdpater(requireContext(), list)
                        view.gvFoods.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

                if (pDialog != null && pDialog.isShowing()) {
                    pDialog.dismiss()
                }
            }
        })
        return view
    }

    class MovieAdpater : BaseAdapter {
        var foodsList = ArrayList<MovieInput>()
        var context: Context? = null

        constructor(context: Context, foodsList: ArrayList<MovieInput>) : super() {
            this.context = context
            this.foodsList = foodsList
        }



        override fun getCount(): Int {
            return foodsList.size
        }

        override fun getItem(position: Int): Any {
            return foodsList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val food = this.foodsList[position]

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.movie_items, null)


            Picasso.with(context).load(food.Poster).into(foodView.imgFood)
            foodView.tvName.text = food.Title!!
            foodView.img_fav.setOnClickListener {

                Toast.makeText(context,"Added",Toast.LENGTH_SHORT).show()
}
            return foodView
        }
    }

    lateinit var pDialog: ProgressDialog

    fun DisplayProgressDialog() {

        pDialog = ProgressDialog(context)
        pDialog!!.setMessage("Loading..")
        pDialog!!.setCancelable(false)
        pDialog!!.isIndeterminate = false
        pDialog!!.show()

    }
}
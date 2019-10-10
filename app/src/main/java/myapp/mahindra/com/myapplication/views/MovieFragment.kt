package myapp.mahindra.com.myapplication.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.movie_items.view.*
import myapp.mahindra.com.myapplication.R
import myapp.mahindra.com.myapplication.model.Movie


class MovieFragment  : Fragment() {
    var adapter: MovieAdpater? = null
    var foodsList = ArrayList<Movie>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_movie, container, false)

        // load foods
        foodsList.add(Movie("Coffee", R.mipmap.ic_launcher, ""))
        foodsList.add(Movie("Espersso", R.mipmap.ic_launcher,""))
        foodsList.add(Movie("French Fires", R.mipmap.ic_launcher,""))
        foodsList.add(Movie("Honey",R.mipmap.ic_launcher,""))
        foodsList.add(Movie("Strawberry", R.mipmap.ic_launcher,""))
        foodsList.add(Movie("Sugar cubes", R.mipmap.ic_launcher,""))
        adapter = MovieAdpater(requireContext(), foodsList)


        gvFoods.adapter = adapter
    }

    class MovieAdpater : BaseAdapter {
        var foodsList = ArrayList<Movie>()
        var context: Context? = null

        constructor(context: Context, foodsList: ArrayList<Movie>) : super() {
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

            foodView.imgFood.setImageResource(food.image!!)
            foodView.tvName.text = food.name!!

            return foodView
        }
    }
}// Required empty public constructor
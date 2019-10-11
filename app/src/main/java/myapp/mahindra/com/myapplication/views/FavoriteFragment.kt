package myapp.mahindra.com.myapplication.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_favorite.view.*
import myapp.mahindra.com.myapplication.R


class FavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_favorite, container, false)
        view.txt.text = "hello"   //add your view before id else getting nullpointer exception
        return view
    }



}// Required empty public constructor  {

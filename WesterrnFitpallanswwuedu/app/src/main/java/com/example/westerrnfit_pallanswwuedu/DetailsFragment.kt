package com.example.westerrnfit_pallanswwuedu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_details, container, false)
        var num = view.findViewById<TextView>(R.id.workout_num)
        var date = view.findViewById<TextView>(R.id.workout_date)
        var type = view.findViewById<TextView>(R.id.workout_type)
        var dur = view.findViewById<TextView>(R.id.workout_dur)
        num.text = "Workout number $numS"
        date.text = "$dateS"
        type.text = "$typeS Run"
        dur.text = "$durS minutes"
        return view
    }

    companion object {
        lateinit var numS : String
        lateinit var dateS : String
        lateinit var typeS : String
        lateinit var durS : String
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(wNum : String, wDate : String, wType : String, wDur : String) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    numS = wNum
                    dateS = wDate
                    typeS = wType
                    durS = wDur
                }
            }
    }
}
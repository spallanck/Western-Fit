package com.example.westerrnfit_pallanswwuedu

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import org.w3c.dom.Text


/**
 * A fragment representing a list of Items.
 */
class WorkoutListFragment : Fragment() {
    lateinit var lv : ListView
    lateinit var adapter: ArrayAdapter<WorkoutData>
    private var columnCount = 1
    lateinit var workOutList : MutableList<WorkoutData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_workout_list_list, container, false)
        //var workoutNum = view.findViewById<TextView>(R.id.number)
        //var workoutDate = view.findViewById<TextView>(R.id.date)
        //var workoutType = view.findViewById<TextView>(R.id.type)
        //var workoutDuration = view.findViewById<TextView>(R.id.duration)
        lv = view.findViewById(R.id.listView)


        adapter = ArrayAdapter<WorkoutData>(inflater.context, android.R.layout.simple_list_item_1, workoutData)
        lv.adapter = adapter
        lv.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedItemText = parent.getItemAtPosition(position)
            var wdSelected = selectedItemText as WorkoutData

            Log.d("HiSophie","$selectedItemText")
            (activity as MainActivity).doDetail(wdSelected)
        }

        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"
        lateinit var workoutData : MutableList<WorkoutData>

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int, workoutDataCopy: MutableList<WorkoutData>) =
            WorkoutListFragment().apply {

                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                    workoutData = workoutDataCopy

                }
            }
    }
}
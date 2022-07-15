package com.example.westerrnfit_pallanswwuedu

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.NumberPicker.OnValueChangeListener
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker





// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [EnterWorkoutDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EnterWorkoutDialogFragment : DialogFragment() {

    var run_types = arrayOf("Road", "Trail", "Beach")
    lateinit var dropdown : Spinner
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


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
        var view = inflater.inflate(R.layout.fragment_enter_workout_dialog, container, false)
        var button = view.findViewById<Button>(R.id.button)
        var numberPicker = view.findViewById<NumberPicker>(R.id.numberPicker)
        var datePicker = view.findViewById<DatePicker>(R.id.datePicker)
        if (requireActivity() != null) {
            dropdown = view.findViewById<Spinner>(R.id.spinner)
            val adapter: ArrayAdapter<String> = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_dropdown_item, run_types)
            dropdown.adapter = adapter
            numberPicker.maxValue = 500;
            numberPicker.minValue = 1;
            numberPicker.setOnValueChangedListener(MyListener())



        }

        button.setOnClickListener {
            //Log.d("HiSophie", "done clicked")
            val text: String = dropdown.getSelectedItem().toString()
            val num : Int = numberPicker.getValue()
            val day: Int = datePicker.getDayOfMonth()
            val month: Int = datePicker.getMonth() + 1
            val year: Int = datePicker.getYear()
            /*
            Log.d("HiSophie", "$day")
            Log.d("HiSophie", "$month")
            Log.d("HiSophie", "$year")
            Log.d("HiSophie", "$text")
            Log.d("HiSophie", "$num")*/
            dismiss()
            (activity as MainActivity).doDone(day, month, year, text, num)
        }
        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EnterWorkoutDialogFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            EnterWorkoutDialogFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {

        override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
            // An item was selected. You can retrieve the selected item using
            var item = parent.getItemAtPosition(pos)
            Log.d("HiSophie", item.toString())
            // parent.getItemAtPosition(pos)
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {
            TODO("Not yet implemented")
        }
    }

    private class MyListener : OnValueChangeListener {
        override fun onValueChange(picker: NumberPicker, oldVal: Int, newVal: Int) {
            //get new value and convert it to String
            //if you want to use variable value elsewhere, declare it as a field
            //of your main function
            val value = "" + newVal
        }
    }
}
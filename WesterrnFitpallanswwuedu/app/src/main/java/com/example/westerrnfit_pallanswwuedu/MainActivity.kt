package com.example.westerrnfit_pallanswwuedu

import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.time.LocalDate
import java.util.*


class WorkoutData {
    var num : Int = 0
    lateinit var date : LocalDate
    lateinit var type : String
    var duration: Int = 0

    constructor(num: Int, date : LocalDate, type: String, duration: Int ) {
        this.num = num
        this.date = date
        this.type = type
        this.duration = duration

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun toString() : String {
       return "$num    ${date.dayOfWeek} ${date.monthValue} ${date.dayOfMonth} ${date.year}"
    }
}

class MainActivity : AppCompatActivity() {
    lateinit var fab_button : FloatingActionButton
    lateinit var workouts : FragmentContainerView
    var workoutNum = 0
    lateinit var workoutFrag : WorkoutListFragment

    companion object {
        var WORKOUTDATALIST : MutableList<WorkoutData> = mutableListOf()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //workouts = findViewById(R.id.listView)
        workoutFrag = WorkoutListFragment.newInstance(1, WORKOUTDATALIST)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView2, workoutFrag, null).commit()
        fab_button = findViewById(R.id.FAB)
        fab_button.setOnClickListener{
            //Log.d("HiSophie","clicked")
            val dialogFragment : DialogFragment = EnterWorkoutDialogFragment.newInstance()
            //val transaction = supportFragmentManager.beginTransaction()
            dialogFragment.show(supportFragmentManager, "test")
            //transaction.replace(R.id.fragmentContainerView, dialogFragment, null).commit()
        }


    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun doDone(day: Int, month: Int, year: Int, type: String, duration: Int) {
        var date = LocalDate.of(year, month, day)
        //val localDate = LocalDate(year, month, day)
        //val date: Date = Date(year, month, day)
        workoutNum += 1
        var workoutData = WorkoutData(workoutNum, date, type, duration)
        var workDate = workoutData.date
        var workType = workoutData.type
        var workDur = workoutData.duration
        WORKOUTDATALIST.add(workoutData)
        workoutFrag.adapter.notifyDataSetChanged()
        /*
        Log.d("HiSophie", "$workoutData")
        Log.d("HiSophie", "$workoutNum")
        Log.d("HiSophie", "$workDate")
        Log.d("HiSophie", "$workType")
        Log.d("HiSophie", "$workDur")*/

    }

    fun doDetail(workout : WorkoutData) {
        val orientation = resources.configuration.orientation
        if (Configuration.ORIENTATION_LANDSCAPE === orientation) {
            Log.d("HiSophie", "Landscape mode")
            val detailsFragment = DetailsFragment.newInstance(workout.num.toString(), workout.date.toString(), workout.type, workout.duration.toString())
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.detailsFragment, detailsFragment, null).commit()
        } else {
            //Do SomeThing;  // Portrait
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("num", workout.num.toString())
            intent.putExtra("date", workout.date.toString())
            intent.putExtra("type", workout.type)
            intent.putExtra("dur", workout.duration.toString())
            startActivity(intent)
        }

    }
}
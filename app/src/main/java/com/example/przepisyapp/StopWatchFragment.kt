package com.example.przepisyapp

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import java.util.*
import kotlin.math.roundToInt


class StopWatchFragment : Fragment(R.layout.fragment_stop_watch){
    private var countdownStarted = false
    private lateinit var serviceIntent: Intent
    private var time = 0.0
    private lateinit var timeTv: TextView
    private lateinit var startStopButton: MaterialButton
    private lateinit var resetButton: MaterialButton
    private lateinit var setButton: MaterialButton
    private lateinit var editTimer: EditText

    private val countdownFinishedReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(requireContext(), "Countdown finished!", Toast.LENGTH_SHORT).show()
        }
    }

    private val updateTimeReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            time = intent.getDoubleExtra(TimerService.TIMER_EXTRA, 0.0)
            timeTv.text = getTimeStringFromCountdown(time)
        }
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        startStopButton = view.findViewById(R.id.startStopButton)
        resetButton = view.findViewById(R.id.resetButton)
        timeTv = view.findViewById(R.id.timeTV)
        setButton = view.findViewById(R.id.buttonSet)
        editTimer = view.findViewById(R.id.editTimer)

        requireActivity().registerReceiver(updateTimeReceiver, IntentFilter(TimerService.TIMER_UPDATED))
        requireActivity().registerReceiver(countdownFinishedReceiver, IntentFilter(TimerService.COUNTDOWN_FINISHED))

        if (savedInstanceState != null) {
            startStopButton.text = savedInstanceState.getString("startStopButtonText")
            startStopButton.icon = requireActivity().getDrawable(savedInstanceState.getInt("startStopButtonIconId"))
            countdownStarted = savedInstanceState.getBoolean("countdownStarted")
            time = savedInstanceState.getDouble("time")
            timeTv.text = getTimeStringFromCountdown(time)
        }

        val updateTime: BroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                time = intent.getDoubleExtra(TimerService.TIMER_EXTRA, 0.0)
                timeTv.text = getTimeStringFromCountdown(time)
            }
        }

        setButton.setOnClickListener{ setTimer() }
        startStopButton.setOnClickListener { startStopCountdown() }
        resetButton.setOnClickListener { resetCountdown() }
        serviceIntent = Intent(requireActivity().applicationContext, TimerService::class.java)
        requireActivity().registerReceiver(updateTime, IntentFilter(TimerService.TIMER_UPDATED))
    }

    private fun setTimer() {
        if (editTimer.text.isNotEmpty()) {
            time = editTimer.text.toString().toDouble() * 60
            timeTv.text = getTimeStringFromCountdown(time)
        }
    }

    private fun resetCountdown() {
        time = 0.0
        timeTv.text = getTimeStringFromCountdown(time)
        if (countdownStarted)
            stopCountdown()
    }

    private fun startStopCountdown() {
        if (countdownStarted)
            stopCountdown()
        else
            startCountdown()
    }

    @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
    private fun startCountdown() {
        if (time <= 0) {
            val countdownDuration = 0.0
            time = countdownDuration
        }
        serviceIntent.putExtra(TimerService.TIMER_EXTRA, time)
        requireActivity().startService(serviceIntent)
        startStopButton.text = "Stop"
        startStopButton.icon = requireActivity().getDrawable(R.drawable.ic_baseline_pause_24)
        countdownStarted = true
    }

    @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
    private fun stopCountdown() {
        requireActivity().stopService(serviceIntent)
        startStopButton.text = "Start"
        startStopButton.icon = requireActivity().getDrawable(R.drawable.ic_baseline_play_arrow_24)
        countdownStarted = false
    }

    private fun getTimeStringFromCountdown(time: Double): String {
        val resultInt = time.roundToInt()
        val hours = resultInt % 86400 / 3600
        val minutes = resultInt % 86400 % 3600 / 60
        val seconds = resultInt % 86400 % 3600 % 60

        return makeTimeStringFromCountdown(hours, minutes, seconds)
    }

    private fun makeTimeStringFromCountdown(hour: Int, min: Int, sec: Int): String =
        String.format("%02d:%02d:%02d", hour, min, sec)

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (countdownStarted)
            outState.putInt("startStopButtonIconId", R.drawable.ic_baseline_pause_24)
        else
            outState.putInt("startStopButtonIconId", R.drawable.ic_baseline_play_arrow_24)

        outState.putString("startStopButtonText", startStopButton.text.toString())
        outState.putBoolean("countdownStarted", countdownStarted)
        outState.putDouble("time", time)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        requireActivity().unregisterReceiver(updateTimeReceiver)
        requireActivity().unregisterReceiver(countdownFinishedReceiver)
    }
}
package com.example.przepisyapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import java.util.*

class TimerService : Service() {
    override fun onBind(p0: Intent?): IBinder? = null

    private val timer = Timer()

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val time = intent.getDoubleExtra(TIMER_EXTRA, 0.0)
        timer.scheduleAtFixedRate(TimeTask(time), 0, 1000)
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }

    private inner class TimeTask(private var time: Double) : TimerTask() {
        override fun run() {
            if (time > 0) {
                val intent = Intent(TIMER_UPDATED)
                time--
                intent.putExtra(TIMER_EXTRA, time)
                sendBroadcast(intent)
            } else {
                timer.cancel()
                stopSelf()
                val intent = Intent(COUNTDOWN_FINISHED)
                sendBroadcast(intent)
            }
        }
    }

    companion object {
        const val TIMER_UPDATED = "timerUpdated"
        const val TIMER_EXTRA = "timerExtra"
        const val COUNTDOWN_FINISHED = "countdownCallbackExtra"
    }
}
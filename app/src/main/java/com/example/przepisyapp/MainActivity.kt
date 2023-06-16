package com.example.przepisyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(R.layout.activity_main), GestureDetector.OnGestureListener {
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var gestureDetector: GestureDetector
    private var x2: Float = 0.0f
    private var x1: Float = 0.0f
    private var tabId = 0
    private var stopwatchFragment: StopWatchFragment? = null

    companion object {
        const val MIN_DISTANCE = 100
    }

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            replaceFragment(InfoFragment())
        }

        bottomNavigation = findViewById(R.id.bottom_navigation_view)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.i_home -> {
                    replaceFragment(InfoFragment())
                    tabId = 0
                }
                R.id.i_food -> {
                    replaceFragment(ListFragment())
                    tabId = 1
                }
                R.id.i_timer -> {
                    if (stopwatchFragment == null) {
                        stopwatchFragment = StopWatchFragment()
                    }
                    replaceFragment(stopwatchFragment!!)
                    tabId = 2
                }
            }
            true
        }

        gestureDetector = GestureDetector(this, this)
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gestureDetector.onTouchEvent(event)

        when (event?.action) {
            0 -> {
                x1 = event.x
            }
            1 -> {
                x2 = event.x

                if (kotlin.math.abs(x2 - x1) > MIN_DISTANCE) {
                    if (x2 > x1) {
                        when (tabId) {
                            0 -> {
                                replaceFragment(ListFragment())
                                tabId = 1
                            }
                            1 -> {
                                replaceFragment(stopwatchFragment ?: StopWatchFragment())
                                tabId = 2
                            }
                            2 -> {
                                replaceFragment(InfoFragment())
                                tabId = 0
                            }
                        }
                    } else {
                        when (tabId) {
                            0 -> {
                                replaceFragment(stopwatchFragment ?: StopWatchFragment())
                                tabId = 2
                            }
                            1 -> {
                                replaceFragment(InfoFragment())
                                tabId = 0
                            }
                            2 -> {
                                replaceFragment(ListFragment())
                                tabId = 1
                            }
                        }
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onDown(p0: MotionEvent?): Boolean {  return false }

    override fun onShowPress(p0: MotionEvent?) {}

    override fun onSingleTapUp(p0: MotionEvent?): Boolean { return false }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean { return false }

    override fun onLongPress(p0: MotionEvent?) {}

    override fun onFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean { return false }
}

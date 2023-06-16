package com.example.przepisyapp

import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.*
import com.google.android.material.floatingactionbutton.FloatingActionButton


class DetailFragment : Fragment(R.layout.fragment_detail) {
    private lateinit var rotateOpen: Animation
    private lateinit var rotateClose: Animation
    private lateinit var fromBottom: Animation
    private lateinit var toBottom: Animation
    private lateinit var mainBtn: FloatingActionButton
    private lateinit var saveBtn: FloatingActionButton
    private var clicked = false

    companion object {
        fun newInstance(route: String, description: String, dishID: Int): DetailFragment {
            val fragment = DetailFragment()
            val args = Bundle()
            args.putString("route", route)
            args.putString("description", description)
            args.putInt("dishID", dishID)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(container?.context).inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val textView = view.findViewById<TextView>(R.id.detail_textview)
        val textView2 = view.findViewById<TextView>(R.id.detail_textview2)
        val imageView = view.findViewById<ImageView>(R.id.detailimage)

        textView.text = this.arguments?.getString("route")
        textView2.text = this.arguments?.getString("description")

        //placeholder image
        val image = R.drawable.route
        imageView.setImageResource(image)

        rotateOpen = AnimationUtils.loadAnimation(view.context, R.anim.rotate_open_anim)
        rotateClose = AnimationUtils.loadAnimation(view.context, R.anim.rotate_close_anim)
        fromBottom = AnimationUtils.loadAnimation(view.context, R.anim.from_bottom_anim)
        toBottom = AnimationUtils.loadAnimation(view.context, R.anim.to_bottom)

        mainBtn = view.findViewById(R.id.main_btn)
        saveBtn = view.findViewById(R.id.save_btn)

        mainBtn.setOnClickListener {
            onMainButtonClicked()
        }

        saveBtn.setOnClickListener {
            copyDescription()
        }
    }

    private fun copyDescription() {
        val clipboard = getSystemService(requireContext(), ClipboardManager::class.java)
        val textToCopy = view?.findViewById<TextView>(R.id.detail_textview2)?.text.toString()
        clipboard?.setPrimaryClip(ClipData.newPlainText("Copied Text", textToCopy))
        Toast.makeText(context, "Text copied to clipboard!", Toast.LENGTH_SHORT).show()
    }

    private fun onMainButtonClicked() {
        setVisibility()
        setAnimation()
        setClickable()
        clicked = !clicked
    }

    private fun setAnimation() {
        if (clicked) {
            saveBtn.visibility = View.INVISIBLE
        } else {
            saveBtn.visibility = View.VISIBLE
        }
    }

    private fun setVisibility() {
        if (clicked) {
            saveBtn.startAnimation(toBottom)
            mainBtn.startAnimation(rotateClose)
        } else {
            saveBtn.startAnimation(fromBottom)
            mainBtn.startAnimation(rotateOpen)
        }
    }

    private fun setClickable() {
        saveBtn.isClickable = !clicked
    }
}
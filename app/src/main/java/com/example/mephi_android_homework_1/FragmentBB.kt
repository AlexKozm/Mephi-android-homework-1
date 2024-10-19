package com.example.mephi_android_homework_1

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlin.random.Random

class FragmentBB : Fragment(R.layout.fragment_b_b) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.setOnClickListenerTo(R.id.button_send_color) {
            val result = Bundle().apply { putInt(BACKGROUND_COLOR, getRandomColor()) }
            parentFragmentManager.setFragmentResult(COLOR_REQUEST, result)
            parentFragmentManager.popBackStack()
        }
    }

    private fun getRandomColor(): Int {
        val rnd = Random
        return Color.argb(
            255,
            rnd.nextInt(256),
            rnd.nextInt(256),
            rnd.nextInt(256)
        )
    }
}
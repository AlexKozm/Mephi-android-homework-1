package com.example.mephi_android_homework_1

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes

const val COLOR_REQUEST = "color_request"
const val BACKGROUND_COLOR = "background_color"

class FragmentBA : Fragment(R.layout.fragment_b_a) {
    @ColorInt
    var backgroundColor: Int? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savedInstanceState?.getInt(BACKGROUND_COLOR)?.let { backgroundColor = it }
        backgroundColor?.let { view.setBackgroundColor(it) }

        view.setOnClickListenerTo(R.id.button_to_fragment_bb) {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, FragmentBB())
                .addToBackStack(null)
                .commit()
        }

        parentFragmentManager.setFragmentResultListener(
            COLOR_REQUEST, this
        ) { _, bundle ->
            if (bundle.containsKey(BACKGROUND_COLOR))
                bundle.getInt(BACKGROUND_COLOR).let { newColor ->
                    view.setBackgroundColor(newColor)
                    backgroundColor = newColor
                }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        backgroundColor?.let { outState.putInt(BACKGROUND_COLOR, it) }
    }
}
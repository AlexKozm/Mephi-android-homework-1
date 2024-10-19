package com.example.mephi_android_homework_1

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        when (intent.getBooleanExtra(WITH_FRAGMENT, false)) {
            true -> {
                setContentView(R.layout.activity_b_fragment)
                undoFragmentReplacementInHorizontalMode()
            }
            false -> setContentView(R.layout.activity_b)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setOnClickListenerTo(R.id.button_to_activity_c) {
            startActivity(singleTopIntentTo<ActivityC>())
        }
    }

    private fun undoFragmentReplacementInHorizontalMode() {
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE &&
            supportFragmentManager.backStackEntryCount != 0) {
            supportFragmentManager.popBackStack()
        }
    }
}
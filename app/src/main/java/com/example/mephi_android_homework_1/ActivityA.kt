package com.example.mephi_android_homework_1

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val WITH_FRAGMENT = "with_fragment"

class ActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_a)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.i(TAG, "onCreate")

        setOnClickListenerTo(R.id.button_to_activity_b) { startActivityB() }
        setOnClickListenerTo(R.id.button_to_fragment_b) { startActivityB(withFragment = true) }

    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.i(TAG, "onNewIntent: $intent")
    }

    private fun startActivityB(withFragment: Boolean = false) {
        val intent = singleTopIntentTo<ActivityB>().apply {
            addFlags(FLAG_ACTIVITY_NEW_TASK)
            putExtra(WITH_FRAGMENT, withFragment)
        }
        startActivity(intent)
    }
}
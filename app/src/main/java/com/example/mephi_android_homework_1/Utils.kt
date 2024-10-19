package com.example.mephi_android_homework_1

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity

inline fun <reified T: AppCompatActivity> Context.singleTopIntentTo() =
    Intent(this, T::class.java).apply {
        addFlags(FLAG_ACTIVITY_SINGLE_TOP)
    }

val Any.TAG get() = this::class.simpleName

fun AppCompatActivity.setOnClickListenerTo(@IdRes id: Int, listener: (View) -> Unit) =
    findViewById<View?>(id)?.setOnClickListener(listener)

fun View.setOnClickListenerTo(@IdRes id: Int, listener: (View) -> Unit) =
    findViewById<View?>(id)?.setOnClickListener(listener)
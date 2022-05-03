package com.example.movieapp.utils

import android.app.Activity
import android.view.View
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar

/**
 * Returns Color from resource.
 * @param id Color Resource ID
 */
fun Activity.getColorRes(@ColorRes id: Int) = ContextCompat.getColor(applicationContext, id)

/**
 * Provides [ViewModel] of type [VM] from [factory]
 */
inline fun <reified VM : ViewModel> AppCompatActivity.viewModelOf(
    factory: ViewModelProvider.Factory
) = ViewModelProvider(this, factory)[VM::class.java]


/**
 * Show snack bar by passing message and duration
 */
fun View.snack(message: String, duration: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(this, message, duration).show()
}


// show view
fun View.show() {
    visibility = View.VISIBLE
}

// hide view
fun View.hide() {
    visibility = View.GONE
}
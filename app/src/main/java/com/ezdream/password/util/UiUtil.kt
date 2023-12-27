package com.ezdream.password.util

import android.app.Activity
import android.content.Context
import android.graphics.Movie
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.google.android.material.snackbar.Snackbar
import java.io.InputStream

object UiUtil {

    fun showSnackBar(parentView: View, message: String) {
        val snack = Snackbar.make(parentView, message, Snackbar.LENGTH_SHORT)
        snack.show()
    }

    fun getDuration(context: Context, id: Int): Int {
        val temp: InputStream = context.resources.openRawResource(id)
        val movie = Movie.decodeStream(temp)
        return movie.duration()
    }

    fun hideKeyboard(activity: Activity) {
        val inputMethodManager =
            activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val currentFocus = activity.currentFocus
        if (currentFocus != null) {
            inputMethodManager.hideSoftInputFromWindow(
                currentFocus.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }

}
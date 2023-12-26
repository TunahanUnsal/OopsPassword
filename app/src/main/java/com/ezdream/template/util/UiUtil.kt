package com.ezdream.template.util

import android.content.Context
import android.graphics.Movie
import android.view.View
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

}
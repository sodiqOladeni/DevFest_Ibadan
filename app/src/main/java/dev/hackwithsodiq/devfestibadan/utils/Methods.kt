package dev.hackwithsodiq.devfestibadan.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import coil.api.load
import com.google.firebase.Timestamp
import dev.hackwithsodiq.devfestibadan.R
import dev.hackwithsodiq.devfestibadan.model.Schedule
import java.text.SimpleDateFormat

class Methods {
}

@BindingAdapter("tagTint")
fun tagTint(textView: TextView, color: Int) {
    // Tint the colored dot
    (textView.compoundDrawablesRelative[0] as? GradientDrawable)?.setColor(
        tagTintOrDefault(
            color,
            textView.context
        )
    )
}

fun tagTintOrDefault(color: Int, context: Context): Int {
    return if (color != Color.TRANSPARENT) {
        color
    } else {
        ContextCompat.getColor(context, R.color.default_tag_color)
    }
}

@BindingAdapter("loadImage")
fun ImageView.loadImage(url: String?) {
    this.load(url)
}

@BindingAdapter("goneIfNull")
fun ImageView.goneIfNull(link: String?) {
    if (link == null || link.isNullOrEmpty() || link.isNullOrBlank() || link == "null") {
        this.visibility = View.GONE
    } else {
        this.visibility = View.VISIBLE
    }
}

@BindingAdapter("convertTimeStamp")
fun TextView.displayTime(time: Timestamp?) {
    time?.let {
        this.text = formatTime(time.toDate().time)
    }
}

@BindingAdapter("colorTagLayout")
fun LinearLayout.colorTagLayout(tag: String) {
    when (tag) {
        "Android" -> {
            this.setBackgroundColor(Color.GREEN)
        }

        "Web" -> {
            this.setBackgroundColor(Color.MAGENTA)
        }

        "Cloud" -> {
            this.setBackgroundColor(Color.CYAN)
        }

        else -> {
            this.setBackgroundColor(Color.GRAY)
        }
    }
}

@BindingAdapter("colorTagText")
fun TextView.colorTagText(tag: String) {
    when (tag) {
        "Android" -> {
            this.setTextColor(Color.BLACK)
        }

        "Web" -> {
            this.setTextColor(Color.BLACK)
        }

        "Cloud" -> {
            this.setTextColor(Color.BLACK)
        }

        else -> {
            this.setTextColor(Color.BLACK)
        }
    }
}

fun filterSchedule(tracK: String, it: List<Schedule>): List<Schedule> {
    return it.filter { it.track == tracK }.sortedBy { it.orderInTheList }
}

fun formatTime(systemTime: Long): String {
    return SimpleDateFormat("HH:mm").format(systemTime).toString()
}
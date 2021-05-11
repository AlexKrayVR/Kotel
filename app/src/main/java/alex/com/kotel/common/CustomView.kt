package alex.com.kotel.common

import alex.com.kotel.logging.Logging
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet

class CustomView (context: Context,attrs:AttributeSet?=null): androidx.appcompat.widget.AppCompatImageView(context,attrs) {


    private lateinit var listener: Listener

    interface Listener {
        fun done()
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Logging.logDebug("image.height: ${this.height}")
        listener.done()

    }
}
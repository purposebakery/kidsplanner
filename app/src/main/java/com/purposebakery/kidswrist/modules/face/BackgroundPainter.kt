package com.purposebakery.kidswrist.modules.face

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.support.v4.content.ContextCompat
import com.purposebakery.kidswrist.R
import com.purposebakery.kidswrist.generic.GenericPainter

class BackgroundPainter : GenericPainter {

    private var initialized: Boolean = false
    private var backgroundPaint: Paint = Paint()
    private var isAmbient: Boolean = false;

    override fun setAmbientMode(isAmbient: Boolean) {
        this.isAmbient = isAmbient
    }

    fun onDraw(context: Context, canvas: Canvas, bounds: Rect): Boolean {
        if (!initialized) {
            initialize(context, bounds)
        }

        if (isAmbient) {
            canvas.drawColor(Color.BLACK)
        } else {
            canvas.drawRect(0f, 0f, bounds.width().toFloat(), bounds.height().toFloat(), backgroundPaint)
        }

        return false
    }

    fun initialize(context: Context, bounds: Rect) {
        initialized = true
        backgroundPaint.color = ContextCompat.getColor(context, R.color.background)
    }

}
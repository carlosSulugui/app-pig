package com.plusdesarrollo.mpxtoolkit.applist.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.plusdesarrollo.mpxtoolkit.applist.R

class AspectRationView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatImageView(context, attrs) {

   var ratio:Float = 1f

    init {
        val  a = context.obtainStyledAttributes(attrs, R.styleable.AspectRationView)
        ratio = a.getFloat(R.styleable.AspectRationView_ratio, 1f)
        a.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)


        var width = measuredWidth
        var height = measuredHeight

        if(width == 0 && height == 0){
            return
        }

        if(width >0 ){
            height = (width * ratio).toInt()
        }else if(height > 0 ){
            width = (height * ratio).toInt()
        }
    }
}
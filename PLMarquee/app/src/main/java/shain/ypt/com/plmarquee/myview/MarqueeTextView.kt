package shain.ypt.com.plmarquee.myview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.TextView
import shain.ypt.com.plmarquee.utils.LogPrinter

/**
 * 跑马灯view
 * Created by yang on 2017/6/19.
 */
class MarqueeTextView : TextView {


    private val TAG:String = "MarqueeTextView->>>>>"

    //第一次绘制
    private var isFirstDraw:Boolean =true
    //文字的宽度
    private var textWidth:Int =0
    //控件宽度
    private var mWidth:Int = 0
    //起始位置
    private var mScrollx:Int = 0

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)




    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        LogPrinter.e(TAG,"----")
    }

    override fun isFocused(): Boolean {
        return true
    }

    override fun onTextChanged(text: CharSequence?, start: Int, lengthBefore: Int, lengthAfter: Int) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
    }

    fun getTextWidth(){
        textWidth= paint.measureText(text.toString()).toInt()
    }


}

package shain.ypt.com.plmarquee.activity

import android.graphics.Paint
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.WindowManager
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_show.*
import shain.ypt.com.plmarquee.R
import shain.ypt.com.plmarquee.utils.SmileTools


/**
 * 跑马灯页面
 * yang 博客：blog.csdn.net/qq_16965811
 */
class ShowActivity : AppCompatActivity() {
    //密度1：1 默认字体
    val DEFAULT_SIZE:Int = 90

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        //设置全屏
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //--------配置跑马灯参数  开始
        var bgColor:Int = intent.getIntExtra(SettingActivity.BG_COLOR, R.color.color000000)
        var fontColor:Int =intent.getIntExtra(SettingActivity.FONT_COLOR, R.color.title_bg)
        textView.setTextColor(this.resources.getColor(fontColor))
        textView.setBackgroundColor(this.resources.getColor(bgColor))
        if(intent.getBooleanExtra(SettingActivity.IS_UNDERLINE,false))
            textView.paint.flags= Paint.UNDERLINE_TEXT_FLAG
        if (intent.getBooleanExtra(SettingActivity.IS_BOLD,false)&&intent.getBooleanExtra(SettingActivity.IS_ITALIC,false)){
            textView.typeface= Typeface.defaultFromStyle(Typeface.BOLD_ITALIC )
        }else{
            if (intent.getBooleanExtra(SettingActivity.IS_BOLD,false))
               textView.typeface= Typeface.defaultFromStyle(Typeface.BOLD )
            if (intent.getBooleanExtra(SettingActivity.IS_ITALIC,false))
                textView.typeface= Typeface.defaultFromStyle(Typeface.ITALIC )
        }
        if (!intent.getStringExtra(SettingActivity.TEXT_VALUE).toString().equals(""))
            textView.text = intent.getStringExtra(SettingActivity.TEXT_VALUE).toString()
        //把特殊字符改为表情显示
        if(!TextUtils.isEmpty(textView.text)){
            if (!textView.text.contains("[")&&!textView.text.contains("]")) return
            val span = SmileTools.getSmiledText(this, textView.text, true)
            // 设置内容
             textView.setText(span, TextView.BufferType.NORMAL)
        }
        //文字大小适配一下
        textView.textSize = DEFAULT_SIZE * resources.displayMetrics.density
        //-------配置跑马灯参数  结束

    }
}



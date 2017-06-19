package shain.ypt.com.plmarquee

import android.graphics.Paint
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        if (!intent.getStringExtra(SettingActivity.TEXT_VALUE).toString().equals(""))
            textView.text = intent.getStringExtra(SettingActivity.TEXT_VALUE).toString()
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

    }
}



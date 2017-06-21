package shain.ypt.com.plmarquee.utils

import android.content.Context
import android.text.Spannable
import android.text.style.ImageSpan
import shain.ypt.com.plmarquee.R
import java.util.*
import java.util.regex.Pattern

/**
 * 表情加载类
 * Created by yang on 2017/6/20.
 * yang 博客：blog.csdn.net/qq_16965811
 */
object SmileTools {

    //根据密度取图片的大小值，即：当屏幕density=1 的时候
    val DEFAULT_SMALL_SIZE:Int = 25
    val DEFAULT_LARGE_SIZE:Int = 250

    private val spannableFactory = Spannable.Factory
            .getInstance()

    //存放表情和key值的集合
     var emoticons = HashMap<Pattern, Int>()
    var  emoticonsKey = mutableListOf<String>()

    //定义表情相对的符号
    val f_static_00 = "[):0]"
    val f_static_01 = "[):]"
    val f_static_02 = "[:D]"
    val f_static_03 = "[;)]"
    val f_static_04 = "[:-o]"
    val f_static_05 = "[:p]"
    val f_static_06 = "[(H)]"
    val f_static_07 = "[:@]"
    val f_static_08 = "[:s]"
    val f_static_09 = "[:$]"
    val f_static_010 = "[:(]"
    val f_static_011 = "[:'(]"
    val f_static_012 = "[:|]"
    val f_static_013 = "[(a)]"
    val f_static_014 = "[8o|]"
    val f_static_015 = "[8-|]"
    val f_static_016 = "[+o(]"
    val f_static_017 = "[<o)]"
    val f_static_018 = "[|-)]"
    val f_static_019 = "[*-)]"
    val f_static_020 = "[:-#]"
    val f_static_021 = "[:-*]"
    val f_static_022 = "[^o)]"
    val f_static_023 = "[8-)]"
    val f_static_024 = "[(|)]"
    val f_static_025 = "[(u)]"
    val f_static_026 = "[(S)]"
    val f_static_027 = "[(*)]"
    val f_static_028 = "[(#)]"
    val f_static_029 = "[(R)]"
    val f_static_030 = "[({)]"
    val f_static_031 = "[(})]"
    val f_static_032 = "[(k)]"
    val f_static_033 = "[(F)]"
    val f_static_034 = "[(W)]"
    val f_static_035 = "[(D)]"

    val f_static_036 = "[(D1)]"
    val f_static_037 = "[(D2)]"
    val f_static_038 = "[(D3)]"
    val f_static_039 = "[(D4)]"
    val f_static_040 = "[(D5)]"
    val f_static_041 = "[(D6)]"
    val f_static_042 = "[(D7)]"
    val f_static_043 = "[(D8)]"
    val f_static_044 = "[(D9)]"
    val f_static_045 = "[(D10)]"
    val f_static_046 = "[(D11)]"
    val f_static_047 = "[(D12)]"
    val f_static_048 = "[(D13)]"
    val f_static_049 = "[(D14)]"
    val f_static_050 = "[(D15)]"
    val f_static_051 = "[(D16)]"
    val f_static_052 = "[(D17)]"
    val f_static_053 = "[(D18)]"
    val f_static_054 = "[(D19)]"
    val f_static_055 = "[(D20)]"
    val f_static_056 = "[(D21)]"
    val f_static_057 = "[(D22)]"
    val f_static_058 = "[(D23)]"
    val f_static_059 = "[(D24)]"
    val f_static_060 = "[(D25)]"
    val f_static_061 = "[(D26)]"
    val f_static_062 = "[(D27)]"



    init {



        addPattern(emoticons, f_static_00, R.mipmap.f_static_00)
        addPattern(emoticons, f_static_01, R.mipmap.f_static_01)
        addPattern(emoticons, f_static_02, R.mipmap.f_static_02)
        addPattern(emoticons, f_static_03, R.mipmap.f_static_03)
        addPattern(emoticons, f_static_04, R.mipmap.f_static_04)
        addPattern(emoticons, f_static_05, R.mipmap.f_static_05)
        addPattern(emoticons, f_static_06, R.mipmap.f_static_06)
        addPattern(emoticons, f_static_07, R.mipmap.f_static_07)
        addPattern(emoticons, f_static_08, R.mipmap.f_static_08)
        addPattern(emoticons, f_static_09, R.mipmap.f_static_09)
        addPattern(emoticons, f_static_010, R.mipmap.f_static_010)
        addPattern(emoticons, f_static_011, R.mipmap.f_static_011)
        addPattern(emoticons, f_static_012, R.mipmap.f_static_012)
        addPattern(emoticons, f_static_013, R.mipmap.f_static_013)
        addPattern(emoticons, f_static_014, R.mipmap.f_static_014)
        addPattern(emoticons, f_static_015, R.mipmap.f_static_015)
        addPattern(emoticons, f_static_016, R.mipmap.f_static_016)
        addPattern(emoticons, f_static_017, R.mipmap.f_static_017)
        addPattern(emoticons, f_static_018, R.mipmap.f_static_018)
        addPattern(emoticons, f_static_019, R.mipmap.f_static_019)
        addPattern(emoticons, f_static_020, R.mipmap.f_static_020)
        addPattern(emoticons, f_static_021, R.mipmap.f_static_021)
        addPattern(emoticons, f_static_022, R.mipmap.f_static_022)
        addPattern(emoticons, f_static_023, R.mipmap.f_static_023)
        addPattern(emoticons, f_static_024, R.mipmap.f_static_024)
        addPattern(emoticons, f_static_025, R.mipmap.f_static_025)
        addPattern(emoticons, f_static_026, R.mipmap.f_static_026)
        addPattern(emoticons, f_static_027, R.mipmap.f_static_027)
        addPattern(emoticons, f_static_028, R.mipmap.f_static_028)
        addPattern(emoticons, f_static_029, R.mipmap.f_static_029)
        addPattern(emoticons, f_static_030, R.mipmap.f_static_030)
        addPattern(emoticons, f_static_031, R.mipmap.f_static_031)
        addPattern(emoticons, f_static_032, R.mipmap.f_static_032)
        addPattern(emoticons, f_static_033, R.mipmap.f_static_033)
        addPattern(emoticons, f_static_034, R.mipmap.f_static_034)
        addPattern(emoticons, f_static_035, R.mipmap.f_static_035)

        addPattern(emoticons, f_static_036, R.mipmap.f_static_036)
        addPattern(emoticons, f_static_037, R.mipmap.f_static_037)
        addPattern(emoticons, f_static_038, R.mipmap.f_static_038)
        addPattern(emoticons, f_static_039, R.mipmap.f_static_039)
        addPattern(emoticons, f_static_040, R.mipmap.f_static_040)
        addPattern(emoticons, f_static_041, R.mipmap.f_static_041)
        addPattern(emoticons, f_static_042, R.mipmap.f_static_042)
        addPattern(emoticons, f_static_043, R.mipmap.f_static_043)
        addPattern(emoticons, f_static_044, R.mipmap.f_static_044)
        addPattern(emoticons, f_static_045, R.mipmap.f_static_045)
        addPattern(emoticons, f_static_046, R.mipmap.f_static_046)
        addPattern(emoticons, f_static_047, R.mipmap.f_static_047)
        addPattern(emoticons, f_static_048, R.mipmap.f_static_048)
        addPattern(emoticons, f_static_049, R.mipmap.f_static_049)
        addPattern(emoticons, f_static_050, R.mipmap.f_static_050)
        addPattern(emoticons, f_static_051, R.mipmap.f_static_051)
        addPattern(emoticons, f_static_052, R.mipmap.f_static_052)
        addPattern(emoticons, f_static_053, R.mipmap.f_static_053)
        addPattern(emoticons, f_static_054, R.mipmap.f_static_054)
        addPattern(emoticons, f_static_055, R.mipmap.f_static_055)
        addPattern(emoticons, f_static_056, R.mipmap.f_static_056)

        addPattern(emoticons, f_static_057, R.mipmap.f_static_057)
        addPattern(emoticons, f_static_058, R.mipmap.f_static_058)
        addPattern(emoticons, f_static_059, R.mipmap.f_static_059)
        addPattern(emoticons, f_static_060, R.mipmap.f_static_060)
        addPattern(emoticons, f_static_061, R.mipmap.f_static_060)
        addPattern(emoticons, f_static_062, R.mipmap.f_static_062)
    }

    private fun addPattern(map: MutableMap<Pattern, Int>, smile: String,
                           resource: Int) {
        map.put(Pattern.compile(Pattern.quote(smile)), resource)
        emoticonsKey.add(smile)
    }

    /**
     * replace existing spannable with smiles

     * @param context
     * *
     * @param spannable
     * *
     * @small 是否为小图，文本框和展示设置不同大小表情图
     * @return
     */
    fun addSmiles(context: Context, spannable: Spannable,small:Boolean): Boolean {
        var hasChanges = false
        for ((key, value) in emoticons) {
            val matcher = key.matcher(spannable)
            while (matcher.find()) {
                var set = true
                for (span in spannable.getSpans(matcher.start(),
                        matcher.end(), ImageSpan::class.java))
                    if (spannable.getSpanStart(span) >= matcher.start() && spannable.getSpanEnd(span) <= matcher.end())
                        spannable.removeSpan(span)
                    else {
                        set = false
                        break
                    }
                if (set) {
                    hasChanges = true
                    val drawable = context.resources.getDrawable(
                            value)
                    val density: Int = context.resources.displayMetrics.density.toInt()
                    if (!small) {
                        drawable.setBounds(0, 0, DEFAULT_SMALL_SIZE * density, DEFAULT_SMALL_SIZE * density)// 这里设置图片的大小
                    }else
                        drawable.setBounds(0,0, DEFAULT_LARGE_SIZE*density,DEFAULT_LARGE_SIZE*density  )
                    val imageSpan = ImageSpan(drawable,
                            ImageSpan.ALIGN_BOTTOM)
                    spannable.setSpan(imageSpan, matcher.start(),
                            matcher.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
            }
        }
        return hasChanges
    }

    fun getSmiledText(context: Context, text: CharSequence,small:Boolean): Spannable {
        val spannable = spannableFactory.newSpannable(text)
        addSmiles(context, spannable,small)
        return spannable
    }

    fun containsKey(key: String): Boolean {
        var b = false
        for ((key1) in emoticons) {
            val matcher = key1.matcher(key)
            if (matcher.find()) {
                b = true
                break
            }
        }

        return b
    }

}
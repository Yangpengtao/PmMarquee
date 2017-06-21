package shain.ypt.com.plmarquee


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_setting.*
import shain.ypt.com.plmarquee.adapter.Adapter
import shain.ypt.com.plmarquee.myview.ItemSpace
import shain.ypt.com.plmarquee.utils.ToastUtil

/**
 * 设置页
 * yang 博客：blog.csdn.net/qq_16965811
 */
class SettingActivity : AppCompatActivity(), View.OnClickListener  {


    //静态常量
    companion object {
        //text值
        val TEXT_VALUE = "TEXT_VALUE"
        //是否加粗
        val IS_BOLD = "IS_BOLD"
        //是否斜体
        val IS_ITALIC = "IS_ITALIC"
        //是否下划线
        val IS_UNDERLINE = "IS_UNDERLINE"
        //字体颜色
        val FONT_COLOR ="FONT_COLOR"
        //背景颜色
        val BG_COLOR ="BG_COLOR"
        //设置字体颜色
        val SET_FONT_COLOR = 1
        //设置背景颜色
        val SET_BG_COLOR = 2
        //添加表情
        val SET_EXPRESSION = 3
        //当前设置，默认为0
        var CURR_SET:Int = 0
    }



    var mGridManager:GridLayoutManager?= null
    var adapter:Adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        init()
        setListener()
    }

    /**
     * 初始化对象
     */
    private fun init() {
        mGridManager =GridLayoutManager(this,6)
        mRecyclerView.addItemDecoration(ItemSpace(4))
    }

    /**
     * 添加点击监听
     */
    private fun setListener() {
        btSubmit!!.setOnClickListener(this)
        tvAddExpression!!.setOnClickListener(this)
        tvBgColor!!.setOnClickListener(this)
        tvFontColor!!.setOnClickListener(this)
    }

    /**
     * 点击监听回调
     */
    override fun onClick(v: View) {
        when (v.id) {
            R.id.tvBgColor -> {
                CURR_SET = SET_BG_COLOR
                showGrid(tvBgColor,etText)
            }
            R.id.tvFontColor -> {
                CURR_SET= SET_FONT_COLOR
                showGrid(tvFontColor,etText)
            }
            R.id.tvAddExpression -> {
                CURR_SET = SET_EXPRESSION
                showGrid(tvFontColor,etText)
            }
            R.id.btSubmit ->
                if (etText!!.text != null)
                    showMarquee(etText!!.text.toString())
            else
                Toast.makeText(this@SettingActivity, "", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * 选择表情
     */
    private fun selectExpression() {
        ToastUtil.show(this,"我们在尽力开发中，尽请期待！")
    }

    /**
     * 选择颜色
     */
    private fun  showGrid(textView: TextView?,etText:EditText?) {
        adapter  =Adapter(this, textView!!, etText!!)
        mRecyclerView.layoutManager=mGridManager
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.adapter =adapter
    }

    /**
     * 跳转跑马灯页面
     */
    private fun showMarquee(text: String?) {
        val intent = Intent(this@SettingActivity, ShowActivity::class.java)
        intent.putExtra(TEXT_VALUE, text)
        intent.putExtra(IS_BOLD,cbBold.isChecked)
        intent.putExtra(IS_ITALIC,cbItalic.isChecked)
        intent.putExtra(IS_UNDERLINE,cbUnderline.isChecked)
        if(tvBgColor.tag!=null){
            val color:Int = tvFontColor.tag as Int
            intent.putExtra(FONT_COLOR,color)
        }
        if(tvBgColor.tag!=null){
            val color:Int = tvBgColor.tag as Int
            intent.putExtra(BG_COLOR,color)
        }
        startActivity(intent)
    }




}

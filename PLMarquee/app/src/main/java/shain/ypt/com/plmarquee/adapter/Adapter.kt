package shain.ypt.com.plmarquee.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import shain.ypt.com.plmarquee.R
import shain.ypt.com.plmarquee.activity.SettingActivity
import shain.ypt.com.plmarquee.utils.SmileTools
import shain.ypt.com.plmarquee.utils.getColor


/**
 * Created by yang on 2017/6/20.
 * yang 博客：blog.csdn.net/qq_16965811
 */
class Adapter(private val mContext: Context, private var mTextView: TextView,private var mEtText:EditText) : RecyclerView.Adapter<Adapter.ViewHolder>(), View.OnClickListener {

    private val TAG = "Adapter"

    //1为加载,2为清空
    private var IS_NULL = 1

    init {
        IS_NULL = 1
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        val vh = ViewHolder(view)
        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (SettingActivity.CURR_SET) {
            1,
                //SET_FONT_COLOR
            2 -> {
                //SET_BG_COLOR
                holder.mTextView.visibility = View.GONE
                holder.parent.setBackgroundColor(mContext.resources.getColor(getColor()[position]))
                holder.parent.tag = getColor()[position]
            }
            3 -> {
                //SET_EXPRESSION
                holder.mTextView.visibility = View.VISIBLE
                var smile:String = SmileTools.emoticonsKey[position]
                val span = SmileTools
                        .getSmiledText(mContext,smile ,false)
                // 设置内容
                holder.mTextView.setText(span, TextView.BufferType.SPANNABLE)
                holder.parent.tag = smile
            }else -> {
            }
        }
        holder.parent.setOnClickListener(this)
    }

    override fun getItemCount(): Int {
        if (IS_NULL == 1){
            //字体颜色和背景颜色
            if (SettingActivity.CURR_SET==1|| SettingActivity.CURR_SET==2){
                return getColor().size
            }else{
                //表情
               return SmileTools.emoticons.size
            }

        }else return 0

    }

    override fun onClick(v: View) {
        if (v.tag == null) return
        //设置字体和背景颜色
        if (SettingActivity.CURR_SET == 1 || SettingActivity.CURR_SET == 2) {
            val color = v.tag as Int
            if (mTextView==null) return
            mTextView.setTextColor(mContext.resources.getColor(color))
            mTextView.tag = color
        } else {
            //设置表情
            if (mEtText==null) return
            var smileStr = v.tag.toString()
            setSmile(smileStr)


        }
        clear()
    }


    //设置表情
    private fun setSmile(smileStr:String) {
//        ToastUtil.show(mContext,smileStr)
         mEtText.append(SmileTools.getSmiledText(mContext,smileStr,false))
    }


    /**
     * 清空
     */
    private fun clear() {
        IS_NULL = 2
        this.notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var mTextView: TextView
        var parent: LinearLayout

        init {
            parent = itemView.findViewById(R.id.parent) as LinearLayout
            mTextView = itemView.findViewById(R.id.textView) as TextView
        }
    }
}

package shain.ypt.com.plmarquee.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import shain.ypt.com.plmarquee.R
import shain.ypt.com.plmarquee.SettingActivity
import shain.ypt.com.plmarquee.utils.getColor

/**
 * Created by yang on 2017/6/20.
 * yang 博客：blog.csdn.net/qq_16965811
 */
class Adapter(private val mContext: Context, private val mTextView: TextView) : RecyclerView.Adapter<Adapter.ViewHolder>(), View.OnClickListener {

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
                holder.parent.setBackgroundColor(mContext.resources.getColor(getColor()[position]))
                holder.parent.tag = getColor()[position]
            }
            3 ->
                //SET_EXPRESSION
                holder.mTextView.setTextColor(mContext.resources.getColor(getColor()[position]))
            else -> {
            }
        }
        holder.parent.setOnClickListener(this)
    }

    override fun getItemCount(): Int {
        if (IS_NULL == 1)
            return getColor().size
        else
            return 0

    }

    override fun onClick(v: View) {
        if (v.tag == null) return
        //设置字体和背景颜色
        if (SettingActivity.CURR_SET == 1 || SettingActivity.CURR_SET == 2) {
            val color = v.tag as Int
            mTextView.setTextColor(mContext.resources.getColor(color))
            mTextView.tag = color
        } else {
            //设置表情

        }
        clear()
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

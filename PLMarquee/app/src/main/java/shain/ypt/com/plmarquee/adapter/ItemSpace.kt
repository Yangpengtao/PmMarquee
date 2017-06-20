package shain.ypt.com.plmarquee.adapter

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by yang on 2017/6/20.
 * yang 博客：blog.csdn.net/qq_16965811
 */
class ItemSpace(var mSpace: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        outRect.left = mSpace
        outRect.right = mSpace
        outRect.bottom = mSpace
        outRect.top = mSpace
    }
}

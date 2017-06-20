package shain.ypt.com.plmarquee.utils

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Point
import android.graphics.Rect
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * 获得屏幕相关的辅助类
 * Yang pengtao
 * yang 博客：blog.csdn.net/qq_16965811
 */
class ScreenUtils private constructor() {
    init {
        /* cannot be instantiated */
        throw UnsupportedOperationException("cannot be instantiated")
    }

    companion object {

        /**
         * 获得屏幕高度

         * @param context
         * *
         * @return
         */
        fun getScreenWidth(context: Context): Int {
            val wm = context
                    .getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val outMetrics = DisplayMetrics()
            wm.defaultDisplay.getMetrics(outMetrics)
            return outMetrics.widthPixels
        }

        /**
         * 根据手机的分辨率dp 转成px(像素)
         */
        fun convertDpToPixel(context: Context, dp: Int): Int {
            val displayMetrics = context.resources.displayMetrics
            return (dp * displayMetrics.density).toInt()
        }

        /**
         * 根据手机的分辨率px(像素) 转成dp
         */
        fun convertPixelToDp(context: Context, pixel: Int): Int {
            val displayMetrics = context.resources.displayMetrics
            return (pixel / displayMetrics.density).toInt()
        }

        /**
         * 获得屏幕对象

         * @param context
         * *
         * @return
         */
        fun getScreen(context: Context): DisplayMetrics {
            val wm = context
                    .getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val outMetrics = DisplayMetrics()
            wm.defaultDisplay.getMetrics(outMetrics)
            return outMetrics
        }

        /**
         * 获得屏幕宽度

         * @param context
         * *
         * @return
         */
        fun getScreenHeight(context: Context): Int {
            val wm = context
                    .getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val outMetrics = DisplayMetrics()
            wm.defaultDisplay.getMetrics(outMetrics)
            return outMetrics.heightPixels
        }

        /**
         * 获得状态栏的高度
         */
        fun getStatusHeight(context: Context): Int {

            var statusHeight = -1
            try {
                val clazz = Class.forName("com.android.internal.R\$dimen")
                val `object` = clazz.newInstance()
                val height = Integer.parseInt(clazz.getField("status_bar_height")
                        .get(`object`).toString())
                statusHeight = context.resources.getDimensionPixelSize(height)
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return statusHeight
        }

        /**
         * 获取当前屏幕截图，包含状态栏
         */
        fun snapShotWithStatusBar(activity: Activity): Bitmap {
            val view = activity.window.decorView
            view.isDrawingCacheEnabled = true
            view.buildDrawingCache()
            val bmp = view.drawingCache
            val width = getScreenWidth(activity)
            val height = getScreenHeight(activity)
            var bp: Bitmap? = null
            bp = Bitmap.createBitmap(bmp, 0, 0, width, height)
            view.destroyDrawingCache()
            return bp

        }

        /**
         * 获取当前屏幕截图，不包含状态栏
         */
        fun snapShotWithoutStatusBar(activity: Activity): Bitmap {
            val view = activity.window.decorView
            view.isDrawingCacheEnabled = true
            view.buildDrawingCache()
            val bmp = view.drawingCache
            val frame = Rect()
            activity.window.decorView.getWindowVisibleDisplayFrame(frame)
            val statusBarHeight = frame.top

            val width = getScreenWidth(activity)
            val height = getScreenHeight(activity)
            var bp: Bitmap? = null
            bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height - statusBarHeight)
            view.destroyDrawingCache()
            return bp

        }

        /**
         * 设置背景透明度

         * @param bgAlpha
         */

        fun bgAlpha(activity: Activity, bgAlpha: Float) {
            val lp = activity.window.attributes
            lp.alpha = bgAlpha //0.0-1.0
            activity.window.attributes = lp
        }

        /**
         * get screen height of this cellphone

         * @param context
         * *
         * @return
         */
        fun getMobileHeight(context: Context): Int {
            val dm = DisplayMetrics()
            (context as Activity).windowManager.defaultDisplay.getMetrics(dm)
            val height = dm.heightPixels // 得到高度
            return height
        }

        fun getScreenSize(context: Context): Point {
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = wm.defaultDisplay
            val out = Point()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
                display.getSize(out)
            } else {
                val width = display.width
                val height = display.height
                out.set(width, height)
            }
            return out
        }
    }
}

package shain.ypt.com.plmarquee.utils

import android.content.Context
import android.widget.Toast

/**
 * Toast工具类
 * Yang pengtao
 * Created by root on 16-8-18.
 */
object ToastUtil {
    private var toast: Toast? = null

    fun show(context: Context, str: String) {
        if (toast != null) {
            toast!!.cancel()
        }
        toast = Toast.makeText(context, str, Toast.LENGTH_SHORT)
        toast!!.show()
    }
}

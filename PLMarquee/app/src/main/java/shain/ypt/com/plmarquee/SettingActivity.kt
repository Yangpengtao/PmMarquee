package shain.ypt.com.plmarquee


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity(), View.OnClickListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        setListener()
    }

    private fun setListener() {
        btSubmit!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btSubmit -> if (etText!!.text != null)
                showMarquee(etText!!.text.toString())
            else
                Toast.makeText(this@SettingActivity, "", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showMarquee(text: String?) {
        val intent = Intent(this@SettingActivity, ShowActivity::class.java)
        intent.putExtra(TEXT_VALUE, text)
        intent.putExtra(IS_BOLD,cbBold.isChecked)
        intent.putExtra(IS_ITALIC,cbItalic.isChecked)
        intent.putExtra(IS_UNDERLINE,cbUnderline.isChecked)
        startActivity(intent)
    }

    companion object {
          val TEXT_VALUE = "TEXT_VALUE"
          val IS_BOLD = "IS_BOLD"
          val IS_ITALIC = "IS_ITALIC"
          val IS_UNDERLINE = "IS_UNDERLINE"
    }
}

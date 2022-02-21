package jp.techacademy.yuji.ishibashi.aisatsuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        time_picker_dialog_button.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.time_picker_dialog_button) {
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val date: Date = Date()
        val calendar: Calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"), Locale.JAPAN);

        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                //2:00 ~ 9:59では「おはよう」
                if(hour in 2..9) {
                    textView.text = "おはよう"
                //10:00 ~ 17:59では「こんにちは」
                } else if(hour in 10..17) {
                    textView.text = "こんにちは"
                //上記以外（18:00 ~ 1:59）では「こんばんは」
                } else {
                    textView.text = "こんばんは"
                }
            },
            calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true)
        timePickerDialog.show()
    }
}
package com.phonenumberformatterlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import cn.pedant.SweetAlert.SweetAlertDialog
import com.ikami.phonenumberformatterlibrary.PhoneNumberFormatter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_Format.setOnClickListener {
            var PhoneNo = et_phone_No.text

            if (!PhoneNo.isNullOrEmpty()) {
                if (PhoneNumberFormatter.isValidPhoneNumber(PhoneNo.toString()))
                    et_Result.setText(PhoneNumberFormatter.formatPhoneNumber(PhoneNo.toString()))
                else{
                    SweetAlertDialog(this@MainActivity, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Oops...")
                        .setContentText("Wrong Number Format. Make sure your phone number format is correct  and try again")
                        .show()
                }
            }

           else{
                SweetAlertDialog(this@MainActivity, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Oops...")
                    .setContentText("Please enter Phone Number!")
                    .show()
            }
        }


    }
}

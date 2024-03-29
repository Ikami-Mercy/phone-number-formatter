package com.phonenumberformatterlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.get
import cn.pedant.SweetAlert.SweetAlertDialog
import com.ikami.phonenumberformatterlibrary.PhoneNumberFormatter
import kotlinx.android.synthetic.main.activity_main.*


/**
*Main Activity to test phone formating library
*/
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_Format.setOnClickListener {
            var PhoneNo = et_phone_No.text
            var country = country.getSelectedItem().toString()

            if (!PhoneNo.isNullOrEmpty()) {
                if (PhoneNumberFormatter.isValidPhoneNumber(PhoneNo.toString(),country))
                    et_Result.setText(PhoneNumberFormatter.formatPhoneNumber(PhoneNo.toString(), country))
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

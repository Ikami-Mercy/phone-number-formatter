package com.ikami.phonenumberformatterlibrary

import java.util.regex.Pattern

object PhoneNumberFormatter {


    /**
     * Function to validate phone number
     * @param phoneNumber - phone number to validate
     * @return is valid
     */
    fun isValidPhoneNumber(phoneNumber: String?): Boolean {
        if (phoneNumber != null && phoneNumber != "" && phoneNumber.replace(
                " ".toRegex(),
                ""
            ) != ""
        ) {
            val pattern = Pattern.compile("^(?:254|\\+254|0)?(7[0-9]{8})$")
            return pattern.matcher(phoneNumber).matches()
        }

        return false
    }

    fun formatPhoneNumber(phoneNumber: String): String {
        val phone = cleanPhoneNumber(phoneNumber)
        return phone.replaceFirst("0".toRegex(), "254")
    }

    private fun cleanPhoneNumber(phoneNumber: String): String {
        val formattedNumber: String

        if (phoneNumber.startsWith("+254"))
            formattedNumber = phoneNumber.replace("+254", "0")
        else if (phoneNumber.startsWith("254"))
            formattedNumber = phoneNumber.replace("254", "0")
        else if (phoneNumber.startsWith("7"))
            formattedNumber = "0$phoneNumber"
        else
            formattedNumber = phoneNumber

        return formattedNumber
    }

}

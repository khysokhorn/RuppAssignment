package com.rupp.fe.ruppassignment.utils

import android.text.Editable
import android.text.Html.TagHandler
import org.xml.sax.XMLReader
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


const val baseDateFormat = "yyyy-MMM-dd HH:mm:ssZ"

fun dateTimeConverter(
    dateData: String,
    myFormat: String = "yyyy-MM-dd'T'HH:mm:ss",
    toFormat: String = baseDateFormat
): String? {
    val fmt = SimpleDateFormat(myFormat)
    val fmtOut = SimpleDateFormat(toFormat)
    var result: String? = dateData
    var date: Date? = null
    date = try {
        fmt.parse(dateData)
        // *for some phone format not the same
    } catch (e: ParseException) {

        return dateData
    }

    if (date != null) {
        result = fmtOut.format(date)
    } else { // this is use for only MaterialPicker only
        val fmtOther = SimpleDateFormat("dd MMM yyyy")
        try {
            date = fmtOther.parse(dateData)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        if (date != null) result = fmtOut.format(date)
    }
    // temp
    return result
}

class UlTagHandler : TagHandler {
    override fun handleTag(
        opening: Boolean, tag: String, output: Editable,
        xmlReader: XMLReader?
    ) {
        if (tag == "ul" && !opening) output.append("\n")
        if (tag == "li" && opening) output.append("\n\t•")
    }
}

class IntentConst {
    companion object {
        const val eventModel = "eventModel"
    }
}

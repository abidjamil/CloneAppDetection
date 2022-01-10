package com.abidjamil.cloneappdetection

import android.content.Context
import android.os.Build
import android.util.Log

class CloneDetection(val context: Context, val packageName : String ) {

    private val DUAL_APP_ID_999 = "999"
    private val DOT = '.'
    private var reason = "Original App";

    companion object {
        enum class CloneType {
            OEM, SecondSpace, ThirdParty,
        }
    }
    private fun countOccurrences(s: String, ch: Char): Int {
        return s.filter { it == ch }.count()
    }

     fun checkAppCloning() : Boolean {
        val path: String = context.getFilesDir().getPath()
        val pathStrings = path.split("/".toRegex()).toTypedArray()
        if (path.contains(DUAL_APP_ID_999)) {
            reason = CloneType.OEM.toString()
            return true
        } else if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1 && pathStrings.size > 3 && pathStrings[3] != "0") {
            reason = CloneType.SecondSpace.toString()
            return true
        } else {
            val APP_PACKAGE_DOT_COUNT = countOccurrences(packageName,DOT)
            val count = getDotCount(path)
            if (count > APP_PACKAGE_DOT_COUNT) {
                reason = CloneType.ThirdParty.toString()
                return true
            }
        }
         return false
    }
    fun getCloneDetails() : String {
        checkAppCloning();
        return reason
    }
    private fun getDotCount(path: String): Int {
        val APP_PACKAGE_DOT_COUNT = countOccurrences(packageName,DOT)
        var count = 0
        for (i in 0 until path.length) {
            if (count > APP_PACKAGE_DOT_COUNT) {
                break
            }
            if (path[i] == DOT) {
                count++
            }
        }
        return count
    }
}
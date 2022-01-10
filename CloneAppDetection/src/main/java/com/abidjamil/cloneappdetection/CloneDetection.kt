package com.abidjamil.cloneappdetection

import android.content.Context
import android.os.Build
import android.util.Log

class CloneDetection(private val context: Context, private val packageName : String ) {

    private val dualAppId = "999"
    private val dot = '.'
    private var reason = "Original App"

    enum class CloneType {
        OEM, SecondSpace, ThirdParty,
    }

    private fun countOccurrences(s: String): Int {
        return s.filter { it == dot }.count()
    }

     fun checkAppCloning() : Boolean {
        val path: String = context.filesDir.path
        val pathStrings = path.split("/".toRegex()).toTypedArray()
        if (path.contains(dualAppId)) {
            reason = CloneType.OEM.toString()
            return true
        } else if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1 && pathStrings.size > 3 && pathStrings[3] != "0") {
            reason = CloneType.SecondSpace.toString()
            return true
        } else {
            val appPackageDotCount = countOccurrences(packageName)
            var count = 0
            for (element in path) {
                if (count > appPackageDotCount) {
                    break
                }
                if (element == dot) {
                    count++
                }
            }
            if (count > appPackageDotCount) {
                reason = CloneType.ThirdParty.toString()
                return true
            }
        }
         return false
    }
    fun getCloneDetails() : String {
        checkAppCloning()
        return reason
    }
}
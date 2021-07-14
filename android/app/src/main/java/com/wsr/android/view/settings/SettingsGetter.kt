package com.wsr.android.view.settings

import android.content.Context
import androidx.preference.PreferenceManager

fun checkUseJS(context: Context): Boolean{
    val pref = PreferenceManager.getDefaultSharedPreferences(context)
    return pref.getBoolean("use_js", true)
}

fun checkCollectCountry(context: Context): String{
    val pref = PreferenceManager.getDefaultSharedPreferences(context)
    return pref.getString("collect_country", "JP") ?: "JP"
}

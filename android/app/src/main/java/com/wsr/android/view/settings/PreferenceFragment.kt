package com.wsr.android.view.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.wsr.android.R

class PreferenceFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preference, rootKey)
    }
}

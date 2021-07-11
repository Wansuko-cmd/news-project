package com.wsr.android.view.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wsr.android.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity(){

    private var _binding: ActivitySettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
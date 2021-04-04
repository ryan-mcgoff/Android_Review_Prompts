package com.rmcgoff.reviewpromptsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rmcgoff.reviewpromptsexample.databinding.ActivityMainBinding
import com.rmcgoff.reviewpromptsexample.reviewprompt.ReviewPrompt
import com.rmcgoff.reviewpromptsexample.reviewprompt.ReviewPromptPreferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var reviewPrompt: ReviewPrompt

    @Inject
    lateinit var reviewPromptPreferences: ReviewPromptPreferences

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.apply {
            reviewPromptButton.setOnClickListener {
                reviewPrompt.show(this@MainActivity)
            }
            engagedUserSwitch.setOnCheckedChangeListener { _, isChecked ->
                reviewPromptPreferences.setUserEngagement(isUserHighlyEngaged = isChecked)
            }
        }
    }
}
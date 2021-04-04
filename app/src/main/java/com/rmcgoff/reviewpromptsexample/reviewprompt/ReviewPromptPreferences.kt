package com.rmcgoff.reviewpromptsexample.reviewprompt

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject

class ReviewPromptPreferences @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    fun setUserEngagement(isUserHighlyEngaged: Boolean) =
        sharedPreferences.edit { putBoolean(KEY_HIGHLY_ENGAGED_USER, isUserHighlyEngaged) }

    fun setReviewPromptShown(reviewPromptShown: Boolean) =
        sharedPreferences.edit { putBoolean(KEY_REVIEW_PROMPT_SHOWN, reviewPromptShown) }

    fun isUserHighlyEngaged() = sharedPreferences.getBoolean(KEY_HIGHLY_ENGAGED_USER, false)
    fun hasUserBeenPromptedBefore() = sharedPreferences.getBoolean(KEY_REVIEW_PROMPT_SHOWN, false)

    companion object {
        const val KEY_REVIEW_PROMPT_PREFERENCES_FILE = "REVIEW_PROMPT"
        private const val KEY_HIGHLY_ENGAGED_USER = "HIGHLY_ENGAGED_USER"
        private const val KEY_REVIEW_PROMPT_SHOWN = "REVIEW_PROMPT_SHOWN"
    }
}
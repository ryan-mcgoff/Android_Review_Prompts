package com.rmcgoff.reviewpromptsexample.reviewprompt

import android.app.Activity
import android.content.Context
import com.google.android.play.core.review.ReviewInfo
import com.google.android.play.core.review.ReviewManager
import com.google.android.play.core.review.ReviewManagerFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReviewPrompt @Inject constructor(
    @ApplicationContext private val context: Context,
    private val reviewPromptPreferences: ReviewPromptPreferences
) {
    private val reviewManager: ReviewManager = ReviewManagerFactory.create(context)
    private var reviewInfo: ReviewInfo? = null

    init {
        reviewManager.requestReviewFlow().addOnCompleteListener {
            if (it.isSuccessful) {
                reviewInfo = it.result
            }
        }
    }

    fun show(activity: Activity) {
        reviewInfo?.let {
            if (reviewPromptPreferences.isUserHighlyEngaged() && !reviewPromptPreferences.hasUserBeenPromptedBefore()) {
                val reviewFlow = reviewManager.launchReviewFlow(activity, it)
                reviewFlow.addOnCompleteListener { reviewPrompt ->
                    reviewPromptPreferences.setReviewPromptShown(reviewPrompt.isSuccessful)
                }
            }
        }
    }
}


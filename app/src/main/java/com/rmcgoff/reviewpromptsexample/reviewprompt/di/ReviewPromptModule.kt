package com.rmcgoff.reviewpromptsexample.reviewprompt.di

import android.content.Context
import android.content.SharedPreferences
import com.rmcgoff.reviewpromptsexample.reviewprompt.ReviewPromptPreferences.Companion.KEY_REVIEW_PROMPT_PREFERENCES_FILE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ReviewPromptModule {
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(
            KEY_REVIEW_PROMPT_PREFERENCES_FILE,
            Context.MODE_PRIVATE
        )
    }
}
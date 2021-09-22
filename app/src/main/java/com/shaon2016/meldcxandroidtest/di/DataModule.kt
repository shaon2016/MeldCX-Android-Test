package com.shaon2016.meldcxandroidtest.di

import android.content.Context
import com.shaon2016.meldcxandroidtest.data.local.db.RoomHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideRoomHelper(@ApplicationContext context: Context): RoomHelper {
        return RoomHelper(context)
    }
}
package com.xayappz.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

object AppModule {

  fun provideTestString() ="This is a testing string"


}
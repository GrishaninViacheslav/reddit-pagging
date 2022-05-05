package io.github.grishaninvyacheslav.reddit_pagging

import android.app.Application
import io.github.grishaninvyacheslav.reddit_pagging.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RedditPagingApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RedditPagingApp)
            modules(appModule)
        }
    }
}
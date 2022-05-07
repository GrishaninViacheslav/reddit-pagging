package io.github.grishaninvyacheslav.reddit_pagging.di

import android.content.Context
import androidx.room.Room
import io.github.grishaninvyacheslav.reddit_pagging.BuildConfig
import io.github.grishaninvyacheslav.reddit_pagging.domain.models.RedditListingsCacheDatabase
import io.github.grishaninvyacheslav.reddit_pagging.domain.models.IRedditListingsDataSource
import io.github.grishaninvyacheslav.reddit_pagging.ui.view_models.main.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    factory { provideRetrofit() }
    single { provideNetworkApi(get()) }

    single<RedditListingsCacheDatabase> { provideRedditListingsCacheDB(get()) }
    single { get<RedditListingsCacheDatabase>().dao()}

    viewModel { MainViewModel(get(), get()) }
}

fun provideRetrofit(): Retrofit {
    val loggingInterceptor = HttpLoggingInterceptor()
        .apply { level = HttpLoggingInterceptor.Level.BODY }
    val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    return Retrofit.Builder()
        .baseUrl(BuildConfig.REDDIT_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}

fun provideNetworkApi(retrofit: Retrofit): IRedditListingsDataSource =
    retrofit.create(IRedditListingsDataSource::class.java)

fun provideRedditListingsCacheDB(appContext: Context) =
    Room.databaseBuilder(
        appContext,
        RedditListingsCacheDatabase::class.java, "reddit-listings-cache-database"
    ).build()
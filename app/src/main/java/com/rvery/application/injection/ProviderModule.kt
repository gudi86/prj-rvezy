package com.rvery.application.injection

import android.content.Context
import androidx.room.Room
import com.rvery.BuildConfig
import com.rvery.data.datasource.remote.GetPictureOfCatsService
import com.rvery.interceptor.AddApiKeyInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.Date

@Module
@InstallIn(SingletonComponent::class)
object ProviderModule {

    @Provides
    fun providerOkHttp() : OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(AddApiKeyInterceptor())
            .build()
    }

    @Provides
    fun providerRetrofit(
        okHttpClient: OkHttpClient
    ) : Retrofit {

        return Retrofit.Builder()
            .baseUrl(BuildConfig.URL_API)
            .addConverterFactory(JacksonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}

@Module
@InstallIn(ViewModelComponent::class)
object ProviderServicesModule {

    @Provides
    fun providerGetPictureOfCatsService(retrofit: Retrofit) =
        retrofit.create(GetPictureOfCatsService::class.java)
}
package com.candidate.servando.rest

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RestModule {

    fun <T> createApi(okHttpClient: OkHttpClient, clientClass: Class<T>, baseUrl: String): T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(clientClass)
    }

    fun createHttpClient(interceptors: List<Interceptor>): OkHttpClient {
        val builder = OkHttpClient.Builder()

        for (interceptor in interceptors) {
            builder.addInterceptor(interceptor)
        }
        return builder.build()
    }
}
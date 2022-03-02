package com.rvery.interceptor

import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

class AddApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val request = original.newBuilder()
            .addHeader(
                "x-api-key",
                "24be637f-e596-4847-b47a-1791feeea1bd")
            .build()

        return chain.proceed(request)
    }
}
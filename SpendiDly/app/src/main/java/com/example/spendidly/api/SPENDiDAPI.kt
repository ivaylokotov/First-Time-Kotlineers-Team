package com.example.spendidly.api

import com.example.spendidly.BuildConfig
import com.example.test.data.Budget
import com.example.test.data.Demographics
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface SPENDiDAPI {
    @POST("budgets/generate")
    suspend fun getBudgetAsync(
        @Body demographics: Demographics
    ) : Budget

    companion object {
        const val BASE_URL = "https://api.spendid.io/v1.0/"

        operator fun invoke(): SPENDiDAPI {
            // TODO: Check connectivity for request interceptor
            val requestInterceptor = Interceptor {
                val headers = it.request().headers()
                    .newBuilder()
                    .add("accept", "application/json")
                    .add("content-type", "application/json")
                    .add("x-api-key", BuildConfig.API_KEY)
                    .build()

                val request = it.request()
                    .newBuilder()
                    .headers(headers)
                    .build()

                return@Interceptor it.proceed(request)
            }

            val client: OkHttpClient = OkHttpClient()
                .newBuilder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SPENDiDAPI::class.java) // reflections ftw
        }
    }
}
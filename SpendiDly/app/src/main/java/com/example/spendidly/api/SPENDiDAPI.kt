package com.example.spendidly.api

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
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
import java.io.IOException

interface SPENDiDAPI {
    @POST("budgets/generate")
    suspend fun getBudgetAsync(
        @Body demographics: Demographics
    ) : Budget

    companion object {
        const val BASE_URL = "https://api.spendid.io/v1.0/"

        @RequiresApi(Build.VERSION_CODES.N)
        operator fun invoke(connectivityManager: ConnectivityManager): SPENDiDAPI {
            // TODO: Check connectivity for request interceptor
            val requestInterceptor = Interceptor {
                val activeNetworkInfo = connectivityManager.activeNetwork

                val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetworkInfo)

                if(!(networkCapabilities != null &&
                    networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET))) {
                    throw NoConnectivityException()
                }

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

    class NoConnectivityException : IOException()

}
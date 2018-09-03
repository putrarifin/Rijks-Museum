package com.chyrus.rijksmuseum.network;

import android.util.Log;

import com.chyrus.rijksmuseum.BuildConfig;
import com.google.gson.GsonBuilder;

import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {

    private static final String TAG = "Network";

    public static Retrofit builder(OnRequestTimeOut listener) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    HttpUrl originalHttpUrl = original.url();
                    HttpUrl url = null;
                    HttpUrl.Builder builder = originalHttpUrl.newBuilder();
                    if (original.header("no_param") == null) {
                        builder.addQueryParameter("key", BuildConfig.KEY);
                        builder.addQueryParameter("format", "json");
                    }
                    url = builder.build();

                    Log.d(TAG, "URL: " + url);
                    Request.Builder requestBuilder = original.newBuilder()
                            .url(url);
                    Request request = requestBuilder.build();
                    try {
                        return chain.proceed(request);
                    } catch (SocketTimeoutException exception) {
                        exception.printStackTrace();
                        listener.onConnectionTimeout();
                    }
                    return chain.proceed(request);
                })
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.MAIN_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}

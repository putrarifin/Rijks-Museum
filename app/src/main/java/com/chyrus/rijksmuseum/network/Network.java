package com.chyrus.rijksmuseum.network;

import com.chyrus.rijksmuseum.BuildConfig;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {

    public static Retrofit builder() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.MAIN_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}

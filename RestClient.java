package com.tolulopealuko.goaliertm.network;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;
import com.tolulopealuko.goaliertm.network.interceptors.AuthTokenRequestInterceptor;
import com.tolulopealuko.goaliertm.network.interceptors.CacheInterceptor;

public class RestClient {
    private static final String BASE_URL = "http://api.football-data.org/v2/competitions/";
    private static final long CACHE_SIZE = 10 * 1024 * 1024;
    private FootballDataService mFootballDataService;

    public RestClient(Context context) {
        // Set up HTTP client with cache
        OkHttpClient httpClient = new OkHttpClient();

        File cacheDirectory = new File(context.getCacheDir(), "HttpCache");
        httpClient.setCache(new Cache(cacheDirectory, CACHE_SIZE));

        httpClient.interceptors().add(new CacheInterceptor());

        // Set up GSON parser
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        // Set up REST adapter
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .setEndpoint(BASE_URL)
                .setClient(new OkClient(httpClient))
                .setConverter(new GsonConverter(gson))
                .setRequestInterceptor(new AuthTokenRequestInterceptor())
                .build();

        mFootballDataService = restAdapter.create(FootballDataService.class);
    }

    public FootballDataService getFootballDataService() {
        return mFootballDataService;
    }

    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error)
    {
        handler.proceed();

    }


}

package com.tolulopealuko.goaliertm.network.interceptors;

import retrofit.RequestInterceptor;

public class AuthTokenRequestInterceptor implements RequestInterceptor {
    private static final String AUTH_HEADER = "X-Auth-Token";
    private static final String AUTH_TOKEN = "31c3d06ac7fe4e3fbae0754c54972e53";

    @Override
    public void intercept(RequestFacade request) {
        request.addHeader(AUTH_HEADER, AUTH_TOKEN);
    }
}

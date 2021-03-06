package com.flj.latte.net.interceptors;

import android.support.annotation.NonNull;

import com.flj.latte.app.ConfigKeys;
import com.flj.latte.util.storage.LattePreference;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public final class SyncWebApiCookieToNativeInterceptor implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        final Request.Builder builder = chain.request().newBuilder();
        final String nativeCookie = LattePreference.getCustomAppProfile(ConfigKeys.COOKIE);
        if (nativeCookie != null) {
            builder.removeHeader("Cookie");
            builder.addHeader("Cookie", nativeCookie);
        }
        return chain.proceed(builder.build());
    }
}
package com.flj.latte.fragments.web.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.webkit.URLUtil;
import android.webkit.WebView;

import com.flj.latte.fragments.LatteFragment;
import com.flj.latte.fragments.web.WebFragment;
import com.flj.latte.fragments.web.WebFragmentImpl;

/**
 * Created by 傅令杰
 */

public class Router {

    private Router() {
    }

    private static class Holder {
        private static final Router INSTANCE = new Router();
    }

    public static Router getInstance() {
        return Holder.INSTANCE;
    }

    public final boolean handleWebUrl(WebFragment current, WebFragment next, String url) {

        //如果是电话协议
        if (url.contains("tel:")) {
            callPhone(current.getContext(), url);
            return true;
        }

        final LatteFragment top = current.getTopFragment();
        top.start(next);

        return true;
    }

    //适用于默认情况
    public final boolean handleWebUrl(WebFragment current, String url) {
        return handleWebUrl(current, WebFragmentImpl.create(url), url);
    }

    private void loadWebPage(WebView webView, String url) {
        if (webView != null) {
            webView.loadUrl(url);
        } else {
            throw new NullPointerException("WebView is null!");
        }
    }

    private void loadLocalPage(WebView webView, String url) {
        loadWebPage(webView, "file:///android_asset/" + url);
    }

    private void loadPage(WebView webView, String url) {
        if (URLUtil.isNetworkUrl(url) || URLUtil.isAssetUrl(url)) {
            loadWebPage(webView, url);
        } else {
            loadLocalPage(webView, url);
        }
    }

    public final void loadPage(WebFragment delegate, String url) {
        loadPage(delegate.getWebView(), url);
    }

    private void callPhone(Context context, String uri) {
        final Intent intent = new Intent(Intent.ACTION_DIAL);
        final Uri data = Uri.parse(uri);
        intent.setData(data);
        ContextCompat.startActivity(context, intent, null);
    }
}

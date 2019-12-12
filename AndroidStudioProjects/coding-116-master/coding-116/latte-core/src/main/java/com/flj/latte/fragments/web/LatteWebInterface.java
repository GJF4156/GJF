package com.flj.latte.fragments.web;

import android.webkit.JavascriptInterface;

import com.alibaba.fastjson.JSON;
import com.flj.latte.fragments.web.event.Event;
import com.flj.latte.fragments.web.event.EventManager;
import com.flj.latte.util.log.LatteLogger;

/**
 * Created by 傅令杰
 */

final class LatteWebInterface {
    private final WebFragment mFragment;

    private LatteWebInterface(WebFragment delegate) {
        this.mFragment = delegate;
    }

    static LatteWebInterface create(WebFragment delegate) {
        return new LatteWebInterface(delegate);
    }

    @SuppressWarnings("unused")
    @JavascriptInterface
    public String event(String params) {
        final String action = JSON.parseObject(params).getString("action");
        final Event event = EventManager.getInstance().createEvent(action);
        LatteLogger.d("WEB_EVENT", params);
        event.setAction(action);
        event.setFragment(mFragment);
        return event.execute(params);
    }
}

package com.flj.latte.fragments.web.event;

import android.content.Context;
import android.webkit.WebView;

import com.flj.latte.fragments.LatteFragment;
import com.flj.latte.fragments.web.WebFragment;

/**
 * Created by 傅令杰
 */

public abstract class Event implements IEvent {

    private String mAction = null;
    private WebFragment mFragment = null;

    public Context getContext() {
        return mFragment.getContext();
    }

    public WebView getWebView(){
        return mFragment.getWebView();
    }

    public String getAction() {
        return mAction;
    }

    public void setAction(String mAction) {
        this.mAction = mAction;
    }

    public LatteFragment getFragment() {
        return mFragment;
    }

    public void setFragment(WebFragment mDelegate) {
        this.mFragment = mDelegate;
    }

    public String getUrl() {
        return mFragment.getUrl();
    }
}

package com.item.week10.Iconfont;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

@SuppressLint("AppCompatCustomView")
public class IconfontTextview extends TextView {
    public IconfontTextview(Context context) {
        super(context);
        init(context);
    }

    public IconfontTextview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public IconfontTextview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context){
        Typeface iconfont = Typeface.createFromAsset(context.getAssets(),"iconfont.ttf");
        setTypeface(iconfont);
    }

}

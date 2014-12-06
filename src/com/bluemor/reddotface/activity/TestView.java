package com.bluemor.reddotface.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.ipcjs.utils.L;

/**
 * Created by JiangSong on 2014/12/6.
 */
public class TestView extends RelativeLayout {

    private ViewDragHelper mDragHelper;

    public TestView(Context context) {
        super(context);
        init();
    }

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TestView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean result = false;
        if (ev.getActionMasked() == MotionEvent.ACTION_DOWN) {
//            mDragHelper.processTouchEvent(ev);
            result = false;
        }else{
            result = true;
        }
        mDragHelper.shouldInterceptTouchEvent(ev);
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        try {
            mDragHelper.processTouchEvent(event);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        L.p("处理：" + L.value2FinalString(MotionEvent.class, event.getActionMasked(), "ACTION"));
        return false;
    }

    private void init() {
        mDragHelper = ViewDragHelper.create(this, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View view, int i) {
                return true;
            }

            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                return left;
            }

            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                return top;
            }

            @Override
            public int getViewHorizontalDragRange(View child) {
                return 10;
            }

            @Override
            public int getViewVerticalDragRange(View child) {
                return 10;
            }
        });
    }

}

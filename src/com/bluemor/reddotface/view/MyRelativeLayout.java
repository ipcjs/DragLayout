package com.bluemor.reddotface.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import com.bluemor.reddotface.view.DragLayout.Status;

public class MyRelativeLayout extends RelativeLayout {
    private DragLayout mDragLayout;

    public MyRelativeLayout(Context context) {
        super(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setDragLayout(DragLayout dl) {
        this.mDragLayout = dl;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (mDragLayout.getStatus() != Status.Close) {
            return true;
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mDragLayout.getStatus() != Status.Close) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                mDragLayout.close();
            }
            return true;
        }
        return super.onTouchEvent(event);
    }

}

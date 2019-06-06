package com.jacky.systracedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;

public class GhostTextView extends android.support.v7.widget.AppCompatTextView implements Runnable {
    private int drawCount = 0;

    public GhostTextView(Context context) {
        super(context);
    }

    public GhostTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GhostTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this, 200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d("GhostTextView", "onDraw s: " + drawCount);
        super.onDraw(canvas);
        try {
            int j = 0;
            final long now = System.currentTimeMillis();
            for (int i = 0; i < 100 * 1000; i++) {
                j++;
            }
            Thread.sleep(20 - (System.currentTimeMillis() - now));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d("GhostTextView", "onDraw e: " + drawCount);
        drawCount++;
    }

    @Override
    public void run() {
        invalidate();
        postDelayed(this, 200);
    }
}

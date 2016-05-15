package com.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义音频效果
 * Created by cc on 16/4/23.
 */
public class Volume_View extends View {

    private Paint mPaint;
    private int mRectCount;
    private int mWidth;
    private int mRectWidth;
    private int mRectHeight;
    private int offset = 5;
    private double mRandom;
    private LinearGradient mLinearGradient;


    public Volume_View(Context context) {
        super(context);
        initView();
    }


    public Volume_View(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }


    public Volume_View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GREEN);
//        mPaint.setStyle(Paint.Style.STROKE);
        mRectCount = 12;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mRectCount; i++) {
            mRandom = Math.random();
            float currentHeight = (float)(mRectHeight * mRandom);
            canvas.drawRect(
                    (float)(mWidth*0.4/2+mRectWidth*i+offset)
                    ,currentHeight,
                    (float)(mWidth*0.4/2+mRectWidth*(i+1))
                    ,mRectHeight,mPaint);
        }
        postInvalidateDelayed(300);

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getWidth();
        mRectHeight = getWidth();
        mRectWidth = (int)(mWidth*0.6/mRectCount);
        mLinearGradient = new LinearGradient(0,0,mRectWidth,mRectHeight,Color.YELLOW,Color.GREEN, Shader.TileMode.CLAMP);
        mPaint.setShader(mLinearGradient);

    }
}

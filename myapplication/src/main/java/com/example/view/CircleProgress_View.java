package com.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义圆进度条
 * Created by cc on 16/4/13.
 */
public class CircleProgress_View extends View{

    private int mMeasureSpecWidth,mMeasureSpecHeight;

    private Paint circlePaint;
    private float circleXY;
    private float circleRadius;

    private Paint textPaint;
    private String textString;
    private float textSize;

    private Paint arcPaint;
    private RectF arcRectF;
    private float arcSweepAngle;
    private float arcSweepValue = 30;


    public CircleProgress_View(Context context) {
        super(context);
    }

    public CircleProgress_View(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleProgress_View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mMeasureSpecWidth = MeasureSpec.getSize(widthMeasureSpec);
        mMeasureSpecHeight = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(mMeasureSpecWidth,mMeasureSpecHeight);
        initView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制圆
        canvas.drawCircle(circleXY,circleXY,circleRadius,circlePaint);
        //绘制圆弧
        canvas.drawArc(arcRectF,270,arcSweepAngle,false,arcPaint);
        //绘制圆中字
        canvas.drawText(textString,0,textString.length(),circleXY,circleXY+textSize/4,textPaint);
    }


    private void initView() {
        float length = 0;
        if (mMeasureSpecHeight>=mMeasureSpecWidth){
            length = mMeasureSpecWidth;
        }else {
            length = mMeasureSpecHeight;
        }

        circleXY = length/2;
        circleRadius = (float) (length * 0.5 / 2);
        circlePaint = new Paint();
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(Color.GREEN);

        arcRectF = new RectF(
                (float) (length * 0.1),(float) (length * 0.1),(float) (length * 0.9),(float) (length * 0.9)
        );
        arcSweepAngle = (arcSweepValue /100f)*360f;
        arcPaint = new Paint();
        arcPaint.setAntiAlias(true);
        arcPaint.setColor(Color.RED);
        arcPaint.setStrokeWidth((float) (length*0.1));
        arcPaint.setStyle(Paint.Style.STROKE);


        textString = setTextString();
        textSize = setTextSize();
        textPaint = new Paint();
        textPaint.setTextSize(textSize);
        textPaint.setTextAlign(Paint.Align.CENTER);

    }

    private float setTextSize() {
        this.invalidate();
        return  50;
    }


    private String setTextString() {
        this.invalidate();
        return  "哇哈哈";
    }

    public  void forceInvalidate(){
        this.invalidate();
    }

    public  void setSweepValue(float sweepValue) {
        if (sweepValue != 0) {
            arcSweepValue = sweepValue;
        } else {
            arcSweepValue = 25;
        }
        this.invalidate();
    }


}

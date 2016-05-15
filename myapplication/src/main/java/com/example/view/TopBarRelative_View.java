package com.example.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.R;

/**
 * 自定义顶部
 * Created by cc on 16/4/11.
 */
public class TopBarRelative_View extends RelativeLayout{

    private String mLeftText;
    private int mLeftTextColor;
    private Drawable mLeftBackground;

    private String mTitleText;
    private int mTitleTextColor;
    private float mTitleSize;

    private String mRightText;
    private int mRightTextColor;
    private Drawable mRightBackground;

    private Button mLeftButton,mRightButton;
    private TextView mTitleView;

    private LayoutParams mLeftParams,mTitleParams,mRightParams;
    //传入映射接口对象
    private topbarClickListener mListener;


    public TopBarRelative_View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TopBarRelative_View(Context context) {
        super(context);
    }

    public TopBarRelative_View(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.GREEN);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);

        mLeftText = typedArray.getString(R.styleable.TopBar_leftText);
        mLeftTextColor = typedArray.getColor(R.styleable.TopBar_leftTextColor,0);
        mLeftBackground = typedArray.getDrawable(R.styleable.TopBar_leftBackground);

        mTitleText = typedArray.getString(R.styleable.TopBar_titleText);
        mTitleTextColor = typedArray.getColor(R.styleable.TopBar_leftTextColor,0);
        mTitleSize = typedArray.getFloat(R.styleable.TopBar_titleTextSize,10);

        mRightText = typedArray.getString(R.styleable.TopBar_rightText);
        mRightTextColor = typedArray.getColor(R.styleable.TopBar_leftTextColor,0);
        mRightBackground = typedArray.getDrawable(R.styleable.TopBar_rightBackground);

        typedArray.recycle();

        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTitleView = new TextView(context);

        mLeftButton.setText(mLeftText);
        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mLeftBackground);

        mTitleView.setText(mTitleText);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleSize);
        mTitleView.setGravity(Gravity.CENTER);

        mRightButton.setText(mRightText);
        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackground(mRightBackground);

        mLeftParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        //添加到ViewGroup
        addView(mLeftButton,mLeftParams);

        mRightParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(mRightButton,mRightParams);

        mTitleParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(mTitleView,mTitleParams);

        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.leftClick();
            }
        });


        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.rightClick();
            }
        });
    }


    /*暴露一个外部接口给调用者,设置哥接口回调*/
    public  void setOnTopbarClickListener(topbarClickListener mListener){
        this.mListener = mListener;
    }

    /*设置两边按钮是否显示*/
    public  void setButtonVisable(boolean isLeftVisable,boolean isRightVisable){
        if (isLeftVisable){
            mLeftButton.setVisibility(View.VISIBLE);
        }else {
            mLeftButton.setVisibility(View.GONE);
        }

        if (isRightVisable){
            mRightButton.setVisibility(View.VISIBLE);
        }else {
            mRightButton.setVisibility(View.GONE);
        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("info","onTouchEvent点击事件");
        return super.onTouchEvent(event);
    }


    @Override
    public void setOnTouchListener(OnTouchListener l) {
        Log.i("info","setOnTouchListener点击事件");
        super.setOnTouchListener(l);
    }

    /**
     * 点击接
     */
    public interface topbarClickListener {
        //左点击
        void leftClick();
        //右点击
        void rightClick();

    }



}

package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.view.CircleProgress_View;


/**
 * 自定义圆形进度条儿
 */
public class CircleProgress_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circleprogress);
        CircleProgress_View circleProgress = (CircleProgress_View) findViewById(R.id.circleProgress);
        circleProgress.setSweepValue(70f);

    }




}

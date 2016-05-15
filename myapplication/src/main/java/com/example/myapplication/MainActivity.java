package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 首页选择页
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListener();

    }


    private void initListener() {

        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.YELLOW, Color.GREEN});
        getWindow().setBackgroundDrawable(gradientDrawable);

        findViewById(R.id.defineTextView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SquareTextView_Activity.class));
            }
        });


        findViewById(R.id.lightningTextView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LightningTextView_Activity.class));
            }
        });

        findViewById(R.id.defineTopBarView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TopBar_Activity.class));
            }
        });


        findViewById(R.id.defineProgress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CircleProgress_Activity.class));
            }
        });


        findViewById(R.id.defineVolume).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Volume_Activity.class));
            }
        });

        findViewById(R.id.defineScroll).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MyScrollView_Activity.class));
            }
        });

        findViewById(R.id.animaterTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,AnimatorTest_Activity.class));

            }
        });




    }


    @Override
    public void onClick(View v) {
//        Log.i("type","--------被点击了啊---------");
        switch (v.getId()) {
//        case R.id.defineTextView:
//            startActivity(new Intent(MainActivity.this,SquareTextView_Activity.class));
//            break;
//        case R.id.defineTextView:
//
//            break;
//        case R.id.defineTextView:
//
//            break;


        }


    }
}

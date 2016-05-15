package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.view.TopBarRelative_View;


/**
 * 自定义顶部TopBar
 */
public class TopBar_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topbarview);
        TopBarRelative_View topBar = (TopBarRelative_View) findViewById(R.id.topBar);
        topBar.setOnTopbarClickListener(new TopBarRelative_View.topbarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(TopBar_Activity.this,"左边被点击了",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(TopBar_Activity.this,"右边被点击了",Toast.LENGTH_SHORT).show();

            }
        });

        topBar.setButtonVisable(true,true);

//        TopBar topBar = (TopBar)findViewById(R.id.topBar);
//        topBar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
//            @Override
//            public void leftClick() {
//
//            }
//
//            @Override
//            public void rightClick() {
//
//            }
//        });


    }


}

package com.example.myapplication;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/**
 *动画测试
 */
public class AnimatorTest_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animatortest);


         Button animatorButton = (Button) findViewById(R.id.animatorButton);
        animatorButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(AnimatorTest_Activity.this,"动画被点击了",Toast.LENGTH_SHORT).show();
             }
         });



        //两者全是补间动画
//        Animation animator = AnimationUtils.loadAnimation(this, R.anim.animatortest);
//        animatorButton.setAnimation(animator);
//        animator.setDuration(1000);
//        animator.setFillAfter(true);
//        animator.startNow();

//        Animation animation = new TranslateAnimation(0,300,0,0);// 从上到下移动
//        animation.setDuration(1000);// 动画时长
//        animation.setFillAfter(true);
//        animatorButton.startAnimation(animation);

        //属性动画
        ObjectAnimator.ofFloat(animatorButton,"translationX",0,300).setDuration(1000).start();


//        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) animatorButton.getLayoutParams();
////        params.width +=100;
//        params.leftMargin +=100;
//        animatorButton.requestLayout();//或者
//        animatorButton.setLayoutParams(params);

    }




}

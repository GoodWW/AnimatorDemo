package com.xunman.animatordemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 位移动画  Anima
     */
    private void move() {
      /* //1, 最传统的向右移动动画
        TranslateAnimation animation = new TranslateAnimation(0, 800, 0, 0);
        animation.setDuration(5000);
        animation.setFillAfter(true);//移动完了停留在原地
        ImageView imageView = (ImageView) findViewById(R.id.img);
        imageView.startAnimation(animation);*/

      /* //2,单属性 动画
       //属性动画基本，可以点击的  translationX  是控制imageView的属性  X  是最终到达的距对峙  rotation  旋转属性
        ImageView imageView = (ImageView) findViewById(R.id.img);
//        ObjectAnimator.ofFloat(imageView,"translationX",0f,800f).setDuration(5000).start();
        ObjectAnimator.ofFloat(imageView,"rotation",0f,720f).setDuration(1000).start();*/

        /*//3，普通的组合动画
        ImageView imageView = (ImageView) findViewById(R.id.img);
        ObjectAnimator.ofFloat(imageView,"translationX",0f,800f).setDuration(1000).start();
        ObjectAnimator.ofFloat(imageView,"rotation",0f,360f).setDuration(1000).start();
        ObjectAnimator.ofFloat(imageView,"translationY",0f,800f).setDuration(1000).start();*/

   /*     //3,组合动画的  优化 性能更好
        ImageView imageView = (ImageView) findViewById(R.id.img);
        PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("rotation",0f,360f);
        PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationX",0f,300f);
        PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("translationY",0f,300f);
        ObjectAnimator.ofPropertyValuesHolder(imageView,p1,p2,p3).setDuration(1000).start();*/

        //4,AnimatorSet 实现按顺序播放动画
        ImageView imageView = (ImageView) findViewById(R.id.img);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView,"rotation",0f,360f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView,"translationX",0f,300f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView,"translationY",0f,300f);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animator1,animator2,animator3);
        set.setDuration(1000);
        set.start();
    }

    public void click(View v) {
        switch (v.getId()) {
            case R.id.img:
                Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn:
                move();
                break;
        }
    }
}

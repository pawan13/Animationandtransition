package com.example.android.java;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ScrollView mscroll;
    private TextView mLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the logging comments
        mscroll = (ScrollView)findViewById(R.id.scrolllog);
        mLog = (TextView)findViewById(R.id.tvlog);
        mLog.setText("");
    }


    public void onRuncodeButtonClick(View view) {
        final ValueAnimator animator = ValueAnimator.ofFloat(1f, 20f).setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                displayMessage("timestamp: " + animation.getCurrentPlayTime() +
                        ", values:"+ animation.getAnimatedValue());
            }
        });
        animator.setRepeatCount(2);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();
    }

    public void onClearButtonClick(View view) {
        mLog.setText("");
        mscroll.scrollTo(0, mscroll.getBottom());
    }

    public void displayMessage(String message){
        mLog.append(message + "\n");
        mscroll.scrollTo(0, mscroll.getBottom());
    }
}
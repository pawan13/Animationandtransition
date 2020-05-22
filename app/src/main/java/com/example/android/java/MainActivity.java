package com.example.android.java;

import android.animation.Animator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private AnimationDrawable monkeyAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.animation);
        if(imageView == null)throw new AssertionError();

        imageView.setVisibility(View.INVISIBLE);
        imageView.setBackgroundResource(R.drawable.monkey_animation);

        monkeyAnimation = (AnimationDrawable)imageView.getBackground();
        monkeyAnimation.setOneShot(true);
    }


    public void onStartButtonClick(View view) {
        imageView.setVisibility(View.VISIBLE);
        if(monkeyAnimation.isRunning()){
            monkeyAnimation.stop();
        }
        monkeyAnimation.start();

    }

    public void onStopButtonClick(View view) {
        monkeyAnimation.stop();
    }
}
package com.example.android.java;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
    }


    public void onRunButtonClick(View view) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(imageView,
                "scaleX", 1f, 2f)
                .setDuration(1000);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(imageView,
                "scaleY", 1f, 2f)
                .setDuration(1000);
        AnimatorSet set = new AnimatorSet();
       // set.playTogether(animatorX, animatorY);
        set.playSequentially(animatorX, animatorY);
        set.setDuration(3000); //duration can be overwritten
        set.start();


    }
}
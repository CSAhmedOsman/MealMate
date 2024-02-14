package com.alharbi.mealmate.ui.splash.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.alharbi.mealmate.R;

public class SplashActivity extends AppCompatActivity {

    Handler handler;
    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        animationView = findViewById(R.id.lottie_view);
        animationView.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                //end or transfer
            }
        });

        handler = new Handler(msg -> {
            if (false)
                return true;
            return false;
        });

        handler.sendEmptyMessage(0);

    }
}
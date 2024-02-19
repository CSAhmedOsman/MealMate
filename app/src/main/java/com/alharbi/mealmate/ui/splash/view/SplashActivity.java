package com.alharbi.mealmate.ui.splash.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.alharbi.mealmate.R;
import com.alharbi.mealmate.model.Utils;
import com.alharbi.mealmate.ui.authenticate.view.AuthenticateActivity;
import com.alharbi.mealmate.ui.home.HomeActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    Handler handler;
    LottieAnimationView animationView;
    private FirebaseAuth mAuth;
    private int goTo = Utils.GO_TO_AUTH;

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
                Intent view = new Intent(SplashActivity.this, HomeActivity.class);
                if (goTo == Utils.GO_TO_AUTH)
                    view = new Intent(SplashActivity.this, AuthenticateActivity.class);
                view.setAction(Intent.ACTION_VIEW);
                startActivity(view);
                SplashActivity.this.finish();
            }
        });

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Log.d("TAG", "onStart: " + currentUser.getUid());
            goTo = Utils.GO_TO_HOME;
        } else {
            Log.d("TAG", "onStart: No User");
            goTo = Utils.GO_TO_AUTH;
        }

    }
}
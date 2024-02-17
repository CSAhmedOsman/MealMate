package com.alharbi.mealmate.ui.demo.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.alharbi.mealmate.R;
import com.alharbi.mealmate.database.MealLocalDataSourceImp;
import com.alharbi.mealmate.model.MealRepositoryImp;
import com.alharbi.mealmate.network.MealRemoteDataSourceImp;
import com.alharbi.mealmate.ui.authenticate.view.AuthenticateActivity;
import com.alharbi.mealmate.ui.demo.presenter.DemoPresenter;
import com.alharbi.mealmate.ui.splash.view.SplashActivity;

import java.util.List;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        Button btn = findViewById(R.id.button);
        Intent view = new Intent(this, SplashActivity.class);

        btn.setOnClickListener(v -> {
            startActivity(view);
        });

        DemoPresenter demoPresenter = new DemoPresenter(this,
                MealRepositoryImp.getInstance(MealRemoteDataSourceImp.getInstance(),
                        MealLocalDataSourceImp.getInstance(this)));

        demoPresenter.getData();
    }

    public void showData(List result) {
        Log.i("TAG", "showData: " + result);
    }

    public void showError(String errorMsg) {
        Log.i("TAG", "showError: " + errorMsg);
    }
}
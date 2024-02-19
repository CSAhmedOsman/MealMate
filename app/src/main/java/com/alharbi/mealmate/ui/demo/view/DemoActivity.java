package com.alharbi.mealmate.ui.demo.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.alharbi.mealmate.R;
import com.alharbi.mealmate.datasource.database.MealLocalDataSourceImp;
import com.alharbi.mealmate.model.MealRepositoryImp;
import com.alharbi.mealmate.datasource.network.MealRemoteDataSourceImp;
import com.alharbi.mealmate.model.Utils;
import com.alharbi.mealmate.ui.demo.presenter.DemoPresenter;
import com.alharbi.mealmate.ui.home.HomeActivity;
import com.alharbi.mealmate.ui.mealdetails.view.MealDetailsActivity;

import java.util.List;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        Button btn = findViewById(R.id.button);
        Intent view = new Intent(this, HomeActivity.class);
        view.putExtra(Utils.MEAL_ID,"52772");
        view.putExtra(Utils.TYPE_MEAL_DETAILS,Utils.REMOTE_TYPE);

        btn.setOnClickListener(v -> {
            startActivity(view);
        });

        DemoPresenter demoPresenter = new DemoPresenter(this,
                MealRepositoryImp.getInstance(MealRemoteDataSourceImp.getInstance(),
                        MealLocalDataSourceImp.getInstance(this)));

        //demoPresenter.getData();
    }

    public void showData(List result) {
        Log.i("TAG", "showData: " + result);
    }

    public void showError(String errorMsg) {
        Log.i("TAG", "showError: " + errorMsg);
    }
}
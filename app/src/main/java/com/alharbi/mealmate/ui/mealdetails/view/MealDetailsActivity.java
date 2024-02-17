package com.alharbi.mealmate.ui.mealdetails.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alharbi.mealmate.R;
import com.alharbi.mealmate.model.Utils;

public class MealDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_details);

        Intent intent = getIntent();

        String idMeal = intent.getStringExtra(Utils.MEAL_ID);
        int type = intent.getIntExtra(Utils.TYPE_MEAL_DETAILS, Utils.NA);

    }
}
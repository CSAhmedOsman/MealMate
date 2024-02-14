package com.alharbi.mealmate.database;

import androidx.lifecycle.LiveData;

import com.alharbi.mealmate.model.Meal;

import java.util.List;

public interface MealLocalDataSource {

    void insert(Meal meal);

    void delete(Meal meal);

    LiveData<List<Meal>> getMeals();
}

package com.alharbi.mealmate.database;

import androidx.lifecycle.LiveData;

import com.alharbi.mealmate.model.Meal;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public interface MealLocalDataSource {

    void insert(Meal meal);

    void delete(Meal meal);

    Flowable<List<Meal>> getMeals();
}

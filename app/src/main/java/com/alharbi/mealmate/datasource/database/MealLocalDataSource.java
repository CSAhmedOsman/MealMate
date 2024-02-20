package com.alharbi.mealmate.datasource.database;

import com.alharbi.mealmate.model.Meal;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public interface MealLocalDataSource {

    Completable insert(Meal meal);

    Completable delete(Meal meal);

    Flowable<List<Meal>> getMeals();

    Flowable<List<Meal>> getMeal(String idMeal);

    Completable deleteAll();
}

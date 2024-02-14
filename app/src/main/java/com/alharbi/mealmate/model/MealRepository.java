package com.alharbi.mealmate.model;

import androidx.lifecycle.LiveData;

import com.alharbi.mealmate.network.NetworkCallBack;

import java.util.List;

public interface MealRepository {

    void insertMeal(Meal meal);

    void deleteMeal(Meal meal);

    LiveData<List<Meal>> getLocalMeals();

    void getRemoteData(NetworkCallBack callBack, int callType, String data);

}

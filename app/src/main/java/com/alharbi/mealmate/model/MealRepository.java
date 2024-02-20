package com.alharbi.mealmate.model;

import com.alharbi.mealmate.datasource.network.NetworkCallBack;

public interface MealRepository {

    void insertMeal(NetworkCallBack callBack, Meal meal);

    void deleteMeal(NetworkCallBack callBack, Meal meal);

    void getData(NetworkCallBack callBack, int callType, String data);

    void deleteMeals(NetworkCallBack callBack);
}

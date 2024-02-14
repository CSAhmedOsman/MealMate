package com.alharbi.mealmate.database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.alharbi.mealmate.model.Meal;

import java.util.List;

public class MealLocalDataSourceImp implements MealLocalDataSource {

    private static MealLocalDataSourceImp instance;
    private MealDAO dao;

    private MealLocalDataSourceImp(Context context) {
        AppDataBase dataBase = AppDataBase.getInstance(context.getApplicationContext());
        dao = dataBase.getMealDAO();
    }

    public static MealLocalDataSourceImp getInstance(Context context) {
        if (instance == null)
            instance = new MealLocalDataSourceImp(context);
        return instance;
    }

    @Override
    public void insert(Meal meal) {
        new Thread(() -> dao.insertMeal(meal)).start();
    }

    @Override
    public void delete(Meal meal) {
        new Thread(() -> dao.deleteMeal(meal)).start();
    }

    @Override
    public LiveData<List<Meal>> getMeals() {
        return dao.getMeals();
    }
}

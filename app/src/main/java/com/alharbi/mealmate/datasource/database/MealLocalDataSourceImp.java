package com.alharbi.mealmate.datasource.database;

import android.content.Context;

import com.alharbi.mealmate.model.Meal;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

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
    public Completable insert(Meal meal) {
        return dao.insertMeal(meal).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Completable delete(Meal meal) {
        return dao.deleteMeal(meal).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Flowable<List<Meal>> getMeals() {
        return dao.getMeals().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Flowable<List<Meal>> getMeal(String idMeal) {
        return dao.getMeal(idMeal).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Completable deleteAll() {
        return dao.deleteAllMeals().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}

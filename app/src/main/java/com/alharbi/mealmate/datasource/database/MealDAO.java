package com.alharbi.mealmate.datasource.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.alharbi.mealmate.model.Meal;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface MealDAO {

    @Query("SELECT * FROM meal")
    Flowable<List<Meal>> getMeals();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public Completable insertMeal(Meal meal);

    @Delete
    public Completable deleteMeal(Meal meal);

}

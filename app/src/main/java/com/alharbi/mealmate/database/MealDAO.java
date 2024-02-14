package com.alharbi.mealmate.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.alharbi.mealmate.model.Meal;

import java.util.List;

@Dao
public interface MealDAO {

    @Query("SELECT * FROM meal")
    LiveData<List<Meal>> getMeals();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertMeal(Meal meal);

    @Delete
    public void deleteMeal(Meal meal);


}

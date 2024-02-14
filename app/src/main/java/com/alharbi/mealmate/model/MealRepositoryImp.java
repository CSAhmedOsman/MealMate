package com.alharbi.mealmate.model;

import androidx.lifecycle.LiveData;

import com.alharbi.mealmate.database.MealLocalDataSource;
import com.alharbi.mealmate.network.MealRemoteDataSource;
import com.alharbi.mealmate.network.NetworkCallBack;

import java.util.List;

public class MealRepositoryImp implements MealRepository {


    MealRemoteDataSource remoteDataSource;
    MealLocalDataSource localDataSource;

    private static MealRepositoryImp repository;

    private MealRepositoryImp(MealRemoteDataSource remoteDataSource,
                              MealLocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    public static MealRepositoryImp getInstance(MealRemoteDataSource remoteDataSource,
                                                MealLocalDataSource localDataSource) {
        if (repository == null) {
            repository = new MealRepositoryImp(remoteDataSource, localDataSource);
        }
        return repository;
    }

    @Override
    public void insertMeal(Meal meal) {

    }

    @Override
    public void deleteMeal(Meal meal) {

    }

    @Override
    public LiveData<List<Meal>> getLocalMeals() {
        return null;
    }

    @Override
    public void getRemoteData(NetworkCallBack callBack, int callType, String data) {
        remoteDataSource.makeNetworkCall(callBack, callType, data);
    }
}

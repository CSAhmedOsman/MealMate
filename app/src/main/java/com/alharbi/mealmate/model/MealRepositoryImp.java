package com.alharbi.mealmate.model;

import com.alharbi.mealmate.datasource.database.MealLocalDataSource;
import com.alharbi.mealmate.datasource.network.MealRemoteDataSource;
import com.alharbi.mealmate.datasource.network.NetworkCallBack;

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
    public void insertMeal(NetworkCallBack callBack, Meal meal) {
        localDataSource.insert(meal).subscribe(
                () -> callBack.onSuccess(),
                throwable -> callBack.onFailure(throwable.getMessage())
        );
    }

    @Override
    public void deleteMeal(NetworkCallBack callBack, Meal meal) {
        localDataSource.delete(meal).subscribe(
                () -> callBack.onSuccess(),
                throwable -> callBack.onFailure(throwable.getMessage())
        );
    }

    @Override
    public void getData(NetworkCallBack callBack, int callType, String data) {
        if (callType == Utils.LOCAL_TYPE) {
            localDataSource.getMeal(data).subscribe(
                    meals -> callBack.onSuccessResult(meals, Utils.MEAL_TYPE),
                    throwable -> callBack.onFailure(throwable.getMessage())
            );
        } else if (callType == Utils.LOCAL_MEALS_TYPE) {
            localDataSource.getMeals().subscribe(
                    meals -> callBack.onSuccessResult(meals, Utils.MEAL_TYPE),
                    throwable -> callBack.onFailure(throwable.getMessage())
            );
        } else {
            remoteDataSource.makeNetworkCall(callBack, callType, data);
        }
    }
}

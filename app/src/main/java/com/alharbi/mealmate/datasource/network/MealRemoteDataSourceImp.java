package com.alharbi.mealmate.datasource.network;

import android.util.Log;

import com.alharbi.mealmate.model.MealResponse;
import com.alharbi.mealmate.model.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MealRemoteDataSourceImp implements MealRemoteDataSource {

    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private MealService mealService;
    private static MealRemoteDataSourceImp instance;

    private MealRemoteDataSourceImp() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL).build();

        mealService = retrofit.create(MealService.class);
    }

    public static MealRemoteDataSourceImp getInstance() {
        if (instance == null)
            instance = new MealRemoteDataSourceImp();
        return instance;
    }

    @Override
    public void makeNetworkCall(NetworkCallBack networkDelegate, int callType, String data) {
        Call<MealResponse> call = getCall(callType, data);
        call.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.isSuccessful()) {
                    MealResponse mealResponse = response.body();
                    if (mealResponse != null) {
                        if (callType == Utils.GET_ALL_CATEGORIES)
                            networkDelegate.onSuccessResult(mealResponse.getCategories(), Utils.CATEGORY_TYPE);
                        else
                            networkDelegate.onSuccessResult(mealResponse.getMeals(), Utils.MEAL_TYPE);
                    }
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                networkDelegate.onFailure(t.toString());
                Log.i("TAG", "onFailure: " + t.getMessage());
            }
        });
    }

    private Call<MealResponse> getCall(int callType, String data) {
        switch (callType) {
            case Utils.SEARCH_MEAL_BY_NAME:
                return mealService.searchMealByName(data);
            case Utils.SEARCH_MEAL_BY_FIRST_LETTER:
                return mealService.searchMealByFirstLetter(data);
            case Utils.LOOKUP_MEAL_BY_ID:
                return mealService.lookupMealById(data);

            //-------------------------------------------
            case Utils.LIST_INGREDIENTS:
                return mealService.listIngredients();
            case Utils.LIST_CATEGORIES:
                return mealService.listCategories();
            case Utils.LIST_AREAS:
                return mealService.listAreas();

            //---------------------------------------
            case Utils.FILTER_BY_INGREDIENT:
                return mealService.filterByIngredient(data);
            case Utils.FILTER_BY_CATEGORY:
                return mealService.filterByCategory(data);
            case Utils.FILTER_BY_AREA:
                return mealService.filterByArea(data);

            //---------------------------------------
            case Utils.GET_ALL_CATEGORIES:
                return mealService.getAllCategories();

            default:
                return mealService.getRandomMeal();
        }
    }
}

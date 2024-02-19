package com.alharbi.mealmate.datasource.network;

import com.alharbi.mealmate.model.MealResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface MealService {

    @GET("search.php")
    Call<MealResponse> searchMealByName(@Query("s") String mealName);

    @GET("search.php")
    Call<MealResponse> searchMealByFirstLetter(@Query("f") String letter);

    @GET("lookup.php")
    Call<MealResponse> lookupMealById(@Query("i") String mealId);

    //-----------------------------------
    @GET("list.php?i=list")
    Call<MealResponse> listIngredients();

    @GET("list.php?c=list")
    Call<MealResponse> listCategories();

    @GET("list.php?a=list")
    Call<MealResponse> listAreas();

    //------------------------------------
    @GET("filter.php")
    Call<MealResponse> filterByIngredient(@Query("i") String mainIngredient);

    @GET("filter.php")
    Call<MealResponse> filterByCategory(@Query("c") String category);

    @GET("filter.php")
    Call<MealResponse> filterByArea(@Query("a") String area);

    //------------------------------------
    @GET("categories.php")
    Call<MealResponse> getAllCategories();

    @GET("random.php")
    Call<MealResponse> getRandomMeal();
}

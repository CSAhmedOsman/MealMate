package com.alharbi.mealmate.ui.start.favorites.presenter;

import com.alharbi.mealmate.datasource.network.NetworkCallBack;
import com.alharbi.mealmate.model.MealRepository;
import com.alharbi.mealmate.model.Utils;
import com.alharbi.mealmate.ui.start.favorites.view.FavoritesFragment;

import java.util.List;

public class FavoritesPresenter implements NetworkCallBack {
    FavoritesFragment view;
    MealRepository repository;

    public FavoritesPresenter(FavoritesFragment view, MealRepository repository) {
        this.view = view;
        this.repository = repository;
    }


    public void getData() {
        repository.getData(this, Utils.LOCAL_MEALS_TYPE, "");
    }

    @Override
    public void onSuccessResult(List result, int type) {
        if (type == Utils.MEAL_TYPE)
            view.showMeals(result);
    }

    @Override
    public void onSuccess() {
        //done
    }

    @Override
    public void onFailure(String errorMsg) {
        view.showError(errorMsg);
    }

}

package com.alharbi.mealmate.ui.home.start.presenter;

import com.alharbi.mealmate.datasource.network.NetworkCallBack;
import com.alharbi.mealmate.model.Meal;
import com.alharbi.mealmate.model.MealRepository;
import com.alharbi.mealmate.model.Utils;
import com.alharbi.mealmate.ui.home.start.view.HomeFragment;

import java.util.List;

public class HomePresenter implements NetworkCallBack {
    private final HomeFragment view;
    private final MealRepository repository;

    public HomePresenter(HomeFragment view, MealRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void getData(int type, String data) {
        repository.getRemoteData(this, type, data);
    }

    @Override
    public void onSuccessResult(List result, int type) {
        if (type == Utils.MEAL_TYPE)
            view.showMeal((Meal) result.get(0));
        else if (type == Utils.CATEGORY_TYPE)
            view.showCategories(result);
    }

    @Override
    public void onFailure(String errorMsg) {
        view.showError(errorMsg);
    }

}

package com.alharbi.mealmate.ui.start.search.presenter;

import com.alharbi.mealmate.datasource.network.NetworkCallBack;
import com.alharbi.mealmate.model.MealRepository;
import com.alharbi.mealmate.model.Utils;
import com.alharbi.mealmate.ui.start.search.view.SearchFragment;

import java.util.List;

public class SearchPresenter implements NetworkCallBack {

    private final SearchFragment view;
    private final MealRepository repository;

    public SearchPresenter(SearchFragment view, MealRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void getData(int type) {
        repository.getData(this, type, "");
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

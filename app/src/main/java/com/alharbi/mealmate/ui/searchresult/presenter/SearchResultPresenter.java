package com.alharbi.mealmate.ui.searchresult.presenter;

import com.alharbi.mealmate.datasource.network.NetworkCallBack;
import com.alharbi.mealmate.model.MealRepository;
import com.alharbi.mealmate.model.Utils;
import com.alharbi.mealmate.ui.searchresult.view.SearchResultActivity;

import java.util.List;

public class SearchResultPresenter implements NetworkCallBack {

    private final SearchResultActivity view;
    private final MealRepository repository;

    public SearchResultPresenter(SearchResultActivity view, MealRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void getData(int type, String data) {
        repository.getData(this, type, data);
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

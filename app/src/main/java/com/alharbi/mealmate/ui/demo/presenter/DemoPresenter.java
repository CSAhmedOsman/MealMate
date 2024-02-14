package com.alharbi.mealmate.ui.demo.presenter;

import com.alharbi.mealmate.model.MealRepository;
import com.alharbi.mealmate.model.Utils;
import com.alharbi.mealmate.network.NetworkCallBack;
import com.alharbi.mealmate.ui.demo.view.DemoActivity;
import com.alharbi.mealmate.ui.splash.view.SplashActivity;

import java.util.List;

public class DemoPresenter implements NetworkCallBack {

    private DemoActivity view;
    private MealRepository repository;

    public DemoPresenter(DemoActivity view, MealRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void getData() {
        repository.getRemoteData(this, Utils.SEARCH_MEAL_BY_NAME, "Arrabiata");
    }

    @Override
    public void onSuccessResult(List result) {
        view.showData(result);
    }

    @Override
    public void onFailure(String errorMsg) {
        view.showError(errorMsg);
    }
}

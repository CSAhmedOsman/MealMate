package com.alharbi.mealmate.ui.demo.presenter;

import com.alharbi.mealmate.model.MealRepository;
import com.alharbi.mealmate.model.Utils;
import com.alharbi.mealmate.datasource.network.NetworkCallBack;
import com.alharbi.mealmate.ui.demo.view.DemoActivity;

import java.util.List;

public class DemoPresenter implements NetworkCallBack {

    private DemoActivity view;
    private MealRepository repository;

    public DemoPresenter(DemoActivity view, MealRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void getData() {
        repository.getRemoteData(this, Utils.LIST_INGREDIENTS, "");
    }

    @Override
    public void onSuccessResult(List result, int type) {
        view.showData(result);
    }

    @Override
    public void onFailure(String errorMsg) {
        view.showError(errorMsg);
    }
}

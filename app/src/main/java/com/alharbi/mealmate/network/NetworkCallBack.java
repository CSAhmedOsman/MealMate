package com.alharbi.mealmate.network;

import com.alharbi.mealmate.model.Meal;

import java.util.List;

public interface NetworkCallBack {
    public void onSuccessResult(List result);

    public void onFailure(String errorMsg);
}

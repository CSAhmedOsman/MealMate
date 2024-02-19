package com.alharbi.mealmate.datasource.network;

import java.util.List;

public interface NetworkCallBack {
    public void onSuccessResult(List result, int type);

    public void onFailure(String errorMsg);
}

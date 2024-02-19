package com.alharbi.mealmate.datasource.network;

public interface MealRemoteDataSource {
    void makeNetworkCall(NetworkCallBack networkDelegate, int callType, String data);
}

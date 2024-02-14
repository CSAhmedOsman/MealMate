package com.alharbi.mealmate.network;

public interface MealRemoteDataSource {
    void makeNetworkCall(NetworkCallBack networkDelegate, int callType, String data);
}

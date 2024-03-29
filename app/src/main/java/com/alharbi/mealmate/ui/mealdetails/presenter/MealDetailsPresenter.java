package com.alharbi.mealmate.ui.mealdetails.presenter;

import com.alharbi.mealmate.datasource.network.NetworkCallBack;
import com.alharbi.mealmate.model.Meal;
import com.alharbi.mealmate.model.MealRepository;
import com.alharbi.mealmate.model.Utils;
import com.alharbi.mealmate.ui.mealdetails.view.MealDetailsActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class MealDetailsPresenter implements NetworkCallBack {

    private MealDetailsActivity view;
    private MealRepository repository;
    private FirebaseAuth mAuth;

    public MealDetailsPresenter(MealDetailsActivity view, MealRepository repository) {
        this.view = view;
        this.repository = repository;
        mAuth = FirebaseAuth.getInstance();
    }

    public void getData(int type, String idMeal) {
        repository.getData(this, type, idMeal);
    }

    @Override
    public void onSuccessResult(List result, int type) {
        view.showData((Meal) result.get(0));
    }

    @Override
    public void onSuccess() {
        view.showToast("Done");
    }

    @Override
    public void onFailure(String errorMsg) {
        view.showError(errorMsg);
    }

    public void changeData(Meal meal, int type) {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            if (type == Utils.INSERT)
                repository.insertMeal(this, meal);
            else if (type == Utils.DELETE) {
                repository.deleteMeal(this, meal);
            }
        } else {
            onFailure("You have to SingIn First");
        }
    }
}
package com.alharbi.mealmate.ui.start.profile.presenter;

import com.alharbi.mealmate.datasource.network.NetworkCallBack;
import com.alharbi.mealmate.model.MealRepository;
import com.alharbi.mealmate.ui.start.profile.view.ProfileFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class ProfilePresenter implements NetworkCallBack {

    private ProfileFragment view;
    private MealRepository repository;
    private FirebaseAuth mAuth;
    FirebaseUser currentUser;

    public ProfilePresenter(ProfileFragment view, MealRepository repository) {
        this.view = view;
        this.repository = repository;
        mAuth = FirebaseAuth.getInstance();
        isSignIn();
    }

    private void isSignIn() {
        currentUser = mAuth.getCurrentUser();
        view.updateUi(currentUser);
    }

    public void getData(int type, String idMeal) {
        repository.getData(this, type, idMeal);
    }

    @Override
    public void onSuccessResult(List result, int type) {
    }

    @Override
    public void onSuccess() {
        view.showToast("Done");
    }

    @Override
    public void onFailure(String errorMsg) {
        view.showError(errorMsg);
    }

    public void signOut() {
        if (currentUser != null) {
            mAuth.signOut();
            repository.deleteMeals(this);
            view.getActivity().recreate();
        }
    }
}
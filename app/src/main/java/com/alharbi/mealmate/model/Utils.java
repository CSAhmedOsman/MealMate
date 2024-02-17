package com.alharbi.mealmate.model;


import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.alharbi.mealmate.ui.home.view.HomeActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Utils {
    public static final int NA = -1;

    //-------------------------------
    public static final int SEARCH_MEAL_BY_NAME = 1;
    public static final int SEARCH_MEAL_BY_FIRST_LETTER = 2;
    public static final int LOOKUP_MEAL_BY_ID = 3;

    //-------------------------------
    public static final int LIST_INGREDIENTS = 4;
    public static final int LIST_CATEGORIES = 5;
    public static final int LIST_AREAS = 6;

    //-------------------------------
    public static final int FILTER_BY_INGREDIENT = 7;
    public static final int FILTER_BY_CATEGORY = 8;
    public static final int FILTER_BY_AREA = 9;

    //------------------------------
    public static final int GET_ALL_CATEGORIES = 10;
    public static final int GET_RANDOM_MEAL = 11;

    //------------------------------------
    public static final int LOCAL_TYPE = 12;
    public static final int REMOTE_TYPE = 13;

    //------------------------------------
    public static final String MEAL_ID = "idMeal";
    public static final String TYPE_MEAL_DETAILS = "details_type";

    //----------------------------------------
    public static final int GO_TO_HOME = 14;
    public static final int GO_TO_AUTH = 15;

    //-----------------------------------------

    public static void signOut(FirebaseAuth mAuth) {
        mAuth.signOut();
    }

    public static void showProgressBar(ProgressBar loading) {
        if (loading != null) {
            loading.setVisibility(View.VISIBLE);
        }
    }

    public static void hideProgressBar(ProgressBar loading) {
        if (loading != null) {
            loading.setVisibility(View.INVISIBLE);
        }
    }

    public static boolean validateForm(TextInputEditText username, TextInputEditText password, TextInputEditText confirmPassword) {
        boolean valid = true;
        String email = "";
        String pass = "";
        String confPass = "";

        if (username != null) {
            email = username.getText().toString();
            if (TextUtils.isEmpty(email)) {
                username.setError("Required.");
                valid = false;
            } else {
                username.setError(null);
            }
        }

        if (password != null) {
            pass = password.getText().toString();
            if (TextUtils.isEmpty(pass)) {
                password.setError("Required.");
                valid = false;
            } else {
                password.setError(null);
            }
        }

        if (confirmPassword != null) {
            confPass = confirmPassword.getText().toString();
            if (!confPass.equals(pass)) {
                confirmPassword.setError("Not Match.");
                valid = false;
            } else {
                password.setError(null);
            }
        }

        return valid;
    }

    public static void updateUI(FirebaseUser user, Activity activity) {
        if (user != null) {

            Intent intent = new Intent(activity, HomeActivity.class);
            intent.setAction(Intent.ACTION_VIEW);
            activity.startActivity(intent);
            activity.finish();

            Log.i("TAG", "updateUI: Email Verified: " + user.isEmailVerified() + " Id: " + user.getUid());
            Toast.makeText(activity, "Email Verified: " + user.isEmailVerified() + " Id: " + user.getUid(), Toast.LENGTH_SHORT).show();
        } else {
            Log.i("TAG", "updateUI: Email Verified: null user");
            Toast.makeText(activity, "Email Verified: null user", Toast.LENGTH_SHORT).show();
        }
    }

    public static void reload(FirebaseAuth mAuth, Activity activity) {
        mAuth.getCurrentUser().reload().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Utils.updateUI(mAuth.getCurrentUser(), activity);
                Log.i("TAG", "Reload successful!");
                Toast.makeText(activity, "Reload successful!", Toast.LENGTH_SHORT).show();
            } else {
                Log.e("TAG", "Failed to reload user.", task.getException());
                Toast.makeText(activity, "Failed to reload user.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

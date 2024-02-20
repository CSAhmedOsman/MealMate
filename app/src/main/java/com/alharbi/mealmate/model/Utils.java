package com.alharbi.mealmate.model;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.alharbi.mealmate.ui.start.HomeActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

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

    //----------------------------------------
    public static final int GO_TO_HOME = 12;
    public static final int GO_TO_AUTH = 13;

    //------------------------------------
    public static final int MEAL_TYPE = 14;
    public static final int CATEGORY_TYPE = 15;
    public static final int LOCAL_MEAL = 16;
    public static final int LOCAL_MEALS_TYPE = 17;
    public static final int INSERT = 18;
    public static final int DELETE = 19;

    //------------------------------------
    public static final String MEAL_ID = "idMeal";
    public static final String TYPE_MEAL_DETAILS = "details_type";
    public static final String TO_DAY_MEAL = "to_day_meal";
    public static final String FILTER_TYPE = "filter";
    public static final String FILTER_DATA = "filtrate";

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
            Log.i("TAG", "updateUI: Email Not Verified");
            Toast.makeText(activity, "Email Not Verified", Toast.LENGTH_SHORT).show();
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

    public static List<String> getIngredients(Meal meal) {
        List<String> ingredients = new ArrayList<>();
        String strIngredient1 = meal.getStrIngredient1();
        if (strIngredient1 != null && !strIngredient1.isEmpty())
            ingredients.add(strIngredient1);
        String strIngredient2 = meal.getStrIngredient2();
        if (strIngredient2 != null && !strIngredient2.isEmpty())
            ingredients.add(strIngredient2);
        String strIngredient3 = meal.getStrIngredient3();
        if (strIngredient3 != null && !strIngredient3.isEmpty())
            ingredients.add(strIngredient3);
        String strIngredient4 = meal.getStrIngredient4();
        if (strIngredient4 != null && !strIngredient4.isEmpty())
            ingredients.add(strIngredient4);
        String strIngredient5 = meal.getStrIngredient();
        if (strIngredient5 != null && !strIngredient5.isEmpty())
            ingredients.add(strIngredient5);
        String strIngredient6 = meal.getStrIngredient6();
        if (strIngredient6 != null && !strIngredient6.isEmpty())
            ingredients.add(strIngredient6);
        String strIngredient7 = meal.getStrIngredient7();
        if (strIngredient7 != null && !strIngredient7.isEmpty())
            ingredients.add(strIngredient7);
        String strIngredient8 = meal.getStrIngredient8();
        if (strIngredient8 != null && !strIngredient8.isEmpty())
            ingredients.add(strIngredient8);
        String strIngredient9 = meal.getStrIngredient9();
        if (strIngredient9 != null && !strIngredient9.isEmpty())
            ingredients.add(strIngredient9);
        String strIngredient10 = meal.getStrIngredient10();
        if (strIngredient10 != null && !strIngredient10.isEmpty())
            ingredients.add(strIngredient1);
        String strIngredient11 = meal.getStrIngredient11();
        if (strIngredient11 != null && !strIngredient11.isEmpty())
            ingredients.add(strIngredient11);
        String strIngredient12 = meal.getStrIngredient12();
        if (strIngredient12 != null && !strIngredient12.isEmpty())
            ingredients.add(strIngredient12);
        String strIngredient13 = meal.getStrIngredient13();
        if (strIngredient13 != null && !strIngredient13.isEmpty())
            ingredients.add(strIngredient13);
        String strIngredient14 = meal.getStrIngredient14();
        if (strIngredient14 != null && !strIngredient14.isEmpty())
            ingredients.add(strIngredient14);
        String strIngredient15 = meal.getStrIngredient15();
        if (strIngredient15 != null && !strIngredient15.isEmpty())
            ingredients.add(strIngredient15);
        String strIngredient16 = meal.getStrIngredient16();
        if (strIngredient16 != null && !strIngredient16.isEmpty())
            ingredients.add(strIngredient16);
        String strIngredient17 = meal.getStrIngredient17();
        if (strIngredient17 != null && !strIngredient17.isEmpty())
            ingredients.add(strIngredient17);
        String strIngredient18 = meal.getStrIngredient18();
        if (strIngredient18 != null && !strIngredient18.isEmpty())
            ingredients.add(strIngredient18);
        String strIngredient19 = meal.getStrIngredient19();
        if (strIngredient19 != null && !strIngredient19.isEmpty())
            ingredients.add(strIngredient19);
        String strIngredient20 = meal.getStrIngredient20();
        if (strIngredient20 != null && !strIngredient20.isEmpty())
            ingredients.add(strIngredient20);
        return ingredients;
    }

    public static List<String> getMeasures(Meal meal) {
        List<String> measures = new ArrayList<>();
        String strMeasure1 = meal.getStrMeasure1();
        if (strMeasure1 != null && !strMeasure1.isEmpty())
            measures.add(strMeasure1);
        String strMeasure2 = meal.getStrMeasure2();
        if (strMeasure2 != null && !strMeasure2.isEmpty())
            measures.add(strMeasure2);
        String strMeasure3 = meal.getStrMeasure3();
        if (strMeasure3 != null && !strMeasure3.isEmpty())
            measures.add(strMeasure3);
        String strMeasure4 = meal.getStrMeasure4();
        if (strMeasure4 != null && !strMeasure4.isEmpty())
            measures.add(strMeasure4);
        String strMeasure5 = meal.getStrMeasure5();
        if (strMeasure5 != null && !strMeasure5.isEmpty())
            measures.add(strMeasure5);
        String strMeasure6 = meal.getStrMeasure6();
        if (strMeasure6 != null && !strMeasure6.isEmpty())
            measures.add(strMeasure6);
        String strMeasure7 = meal.getStrMeasure7();
        if (strMeasure7 != null && !strMeasure7.isEmpty())
            measures.add(strMeasure7);
        String strMeasure8 = meal.getStrMeasure8();
        if (strMeasure8 != null && !strMeasure8.isEmpty())
            measures.add(strMeasure8);
        String strMeasure9 = meal.getStrMeasure9();
        if (strMeasure9 != null && !strMeasure9.isEmpty())
            measures.add(strMeasure9);
        String strMeasure10 = meal.getStrMeasure10();
        if (strMeasure10 != null && !strMeasure10.isEmpty())
            measures.add(strMeasure1);
        String strMeasure11 = meal.getStrMeasure11();
        if (strMeasure11 != null && !strMeasure11.isEmpty())
            measures.add(strMeasure11);
        String strMeasure12 = meal.getStrMeasure12();
        if (strMeasure12 != null && !strMeasure12.isEmpty())
            measures.add(strMeasure12);
        String strMeasure13 = meal.getStrMeasure13();
        if (strMeasure13 != null && !strMeasure13.isEmpty())
            measures.add(strMeasure13);
        String strMeasure14 = meal.getStrMeasure14();
        if (strMeasure14 != null && !strMeasure14.isEmpty())
            measures.add(strMeasure14);
        String strMeasure15 = meal.getStrMeasure15();
        if (strMeasure15 != null && !strMeasure15.isEmpty())
            measures.add(strMeasure15);
        String strMeasure16 = meal.getStrMeasure16();
        if (strMeasure16 != null && !strMeasure16.isEmpty())
            measures.add(strMeasure16);
        String strMeasure17 = meal.getStrMeasure17();
        if (strMeasure17 != null && !strMeasure17.isEmpty())
            measures.add(strMeasure17);
        String strMeasure18 = meal.getStrMeasure18();
        if (strMeasure18 != null && !strMeasure18.isEmpty())
            measures.add(strMeasure18);
        String strMeasure19 = meal.getStrMeasure19();
        if (strMeasure19 != null && !strMeasure19.isEmpty())
            measures.add(strMeasure19);
        String strMeasure20 = meal.getStrMeasure20();
        if (strMeasure20 != null && !strMeasure20.isEmpty())
            measures.add(strMeasure20);
        return measures;
    }

    public static String getFlagEmoji(String countryName) {
        switch (countryName.toLowerCase()) {
            case "american":
                return "\uD83C\uDDFA\uD83C\uDDF8"; // United States flag emoji
            case "british":
                return "\uD83C\uDDEC\uD83C\uDDE7"; // United Kingdom flag emoji
            case "canadian":
                return "\uD83C\uDDE8\uD83C\uDDE6"; // Canada flag emoji
            case "chinese":
                return "\uD83C\uDDE8\uD83C\uDDF3"; // China flag emoji
            case "croatian":
                return "\uD83C\uDDED\uD83C\uDDF7"; // Croatia flag emoji
            case "dutch":
                return "\uD83C\uDDF3\uD83C\uDDF1"; // Netherlands flag emoji
            case "egyptian":
                return "\uD83C\uDDEA\uD83C\uDDEC"; // Egypt flag emoji
            case "filipino":
                return "\uD83C\uDDEB\uD83C\uDDEE"; // Philippines flag emoji
            case "french":
                return "\uD83C\uDDEB\uD83C\uDDF7"; // France flag emoji
            case "greek":
                return "\uD83C\uDDEC\uD83C\uDDF7"; // Greece flag emoji
            case "indian":
                return "\uD83C\uDDEE\uD83C\uDDF3"; // India flag emoji
            case "irish":
                return "\uD83C\uDDEE\uD83C\uDDEA"; // Ireland flag emoji
            case "italian":
                return "\uD83C\uDDEE\uD83C\uDDF9"; // Italy flag emoji
            case "jamaican":
                return "\uD83C\uDDEF\uD83C\uDDF2"; // Jamaica flag emoji
            case "japanese":
                return "\uD83C\uDDEF\uD83C\uDDF5"; // Japan flag emoji
            case "kenyan":
                return "\uD83C\uDDF0\uD83C\uDDF2"; // Kenya flag emoji
            case "malaysian":
                return "\uD83C\uDDF2\uD83C\uDDFE"; // Malaysia flag emoji
            case "mexican":
                return "\uD83C\uDDF2\uD83C\uDDFD"; // Mexico flag emoji
            case "moroccan":
                return "\uD83C\uDDF2\uD83C\uDDE6"; // Morocco flag emoji
            case "polish":
                return "\uD83C\uDDF5\uD83C\uDDF1"; // Poland flag emoji
            case "portuguese":
                return "\uD83C\uDDF5\uD83C\uDDF9"; // Portugal flag emoji
            case "russian":
                return "\uD83C\uDDF7\uD83C\uDDFA"; // Russia flag emoji
            case "spanish":
                return "\uD83C\uDDEA\uD83C\uDDF8"; // Spain flag emoji
            case "thai":
                return "\uD83C\uDDF9\uD83C\uDDED"; // Thailand flag emoji
            case "tunisian":
                return "\uD83C\uDDF9\uD83C\uDDF3"; // Tunisia flag emoji
            case "turkish":
                return "\uD83C\uDDF9\uD83C\uDDF7"; // Turkey flag emoji
            case "palastine":
                return "\uD83C\uDDF5\uD83C\uDDF8"; // Palestine flag emoji
            case "vietnamese":
                return "\uD83C\uDDFB\uD83C\uDDF3"; // Vietnam flag emoji
            default:
                return "\uD83C\uDDF5\uD83C\uDDF8"; //
        }
    }

    public static Drawable getDrawableFromEmoji(String emoji, View itemView) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(200); // Adjust text size as needed
        paint.setTextAlign(Paint.Align.LEFT);
        int width = (int) paint.measureText(emoji);
        int height = (int) (-paint.ascent() + paint.descent());
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawText(emoji, 0, -paint.ascent(), paint);
        return new BitmapDrawable(itemView.getResources(), bitmap);
    }
}

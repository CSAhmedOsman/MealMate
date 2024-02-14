package com.alharbi.mealmate.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MealResponse implements Parcelable {

    @SerializedName("meals")
    private List<Meal> meals = new ArrayList<>();
    @SerializedName("categories")
    private List<Category> categories = new ArrayList<>();

    public final static Creator<MealResponse> CREATOR = new Creator<MealResponse>() {
        @Override
        public MealResponse createFromParcel(Parcel in) {
            return new MealResponse(in);
        }

        @Override
        public MealResponse[] newArray(int size) {
            return (new MealResponse[size]);
        }
    };

    protected MealResponse(Parcel in) {
        in.readList(this.meals, (Meal.class.getClassLoader()));
        in.readList(this.categories, (Category.class.getClassLoader()));
    }

    public MealResponse() {
    }

    public MealResponse(List<Meal> meals, List<Category> categories) {
        super();
        this.meals = meals;
        this.categories = categories;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "MealResponse{" +
                "meals=" + meals +
                ", categories=" + categories +
                '}';
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(meals);
        dest.writeList(categories);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}

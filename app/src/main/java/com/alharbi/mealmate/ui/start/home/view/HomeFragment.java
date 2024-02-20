package com.alharbi.mealmate.ui.start.home.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alharbi.mealmate.R;
import com.alharbi.mealmate.datasource.database.MealLocalDataSourceImp;
import com.alharbi.mealmate.datasource.network.MealRemoteDataSourceImp;
import com.alharbi.mealmate.model.Category;
import com.alharbi.mealmate.model.Meal;
import com.alharbi.mealmate.model.MealRepositoryImp;
import com.alharbi.mealmate.model.Utils;
import com.alharbi.mealmate.ui.start.home.presenter.HomePresenter;
import com.alharbi.mealmate.ui.mealdetails.view.MealDetailsActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView rvCategories;
    private Meal toDayMeal;
    private TextView tvMealName;
    private ImageView imageMeal;
    private HomePresenter homePresenter;
    private CategoryAdapter categoryAdapter;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private CardView toDayMealView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        homePresenter = new HomePresenter(this, MealRepositoryImp.getInstance(MealRemoteDataSourceImp.getInstance(), MealLocalDataSourceImp.getInstance(getActivity().getApplicationContext())));

        toDayMealView = view.findViewById(R.id.toDayMeal);

        tvMealName = view.findViewById(R.id.tvMealName);
        imageMeal = view.findViewById(R.id.imageMeal);

        rvCategories = view.findViewById(R.id.rvCategories);
        rvCategories.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        categoryAdapter = new CategoryAdapter(getActivity(), new ArrayList<>());
        rvCategories.setAdapter(categoryAdapter);

        sharedPreferences = getContext().getSharedPreferences(Utils.TO_DAY_MEAL, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String savedDay = sharedPreferences.getString(Utils.TO_DAY_MEAL, "");
        String idMeal = sharedPreferences.getString(Utils.MEAL_ID, "");

        String toDay = getDay();
        Log.i("TAG", "onViewCreated: " + savedDay);
        Log.i("TAG", "onViewCreated: " + toDay);

        if (!savedDay.equals(toDay) || idMeal == null || idMeal.isEmpty()) {
            homePresenter.getData(Utils.GET_RANDOM_MEAL, "");
        } else {
            homePresenter.getData(Utils.LOOKUP_MEAL_BY_ID, idMeal);
        }

        homePresenter.getData(Utils.GET_ALL_CATEGORIES, "");
    }

    private static String getDay() {
        String toDay = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalDate currentDate = LocalDate.now();
            toDay = currentDate.getYear() + " " + currentDate.getMonthValue() + " " + currentDate.getDayOfMonth();
        } else {
            Calendar currentDate = Calendar.getInstance();
            toDay = currentDate.get(Calendar.YEAR) + " " + (currentDate.get(Calendar.MONTH) + 1) + " " + currentDate.get(Calendar.DAY_OF_MONTH);
        }
        return toDay;
    }

    void updateToDayMeal() {
        tvMealName.setText(toDayMeal.getStrMeal());
        Glide.with(this)
                .load(toDayMeal.getStrMealThumb())
                .apply(new RequestOptions().override(200, 200))
                .error(R.drawable.gradient_shape)
                .into(imageMeal);
        toDayMealView.setOnClickListener(v -> {
            Intent view = new Intent(getActivity(), MealDetailsActivity.class);
            view.putExtra(Utils.MEAL_ID, toDayMeal.getIdMeal());
            view.putExtra(Utils.TYPE_MEAL_DETAILS, Utils.LOOKUP_MEAL_BY_ID);
            startActivity(view);
        });
    }


    public void showError(String errorMsg) {
        Log.e("TAG", "showError: " + errorMsg);
        Toast.makeText(getContext(), errorMsg, Toast.LENGTH_SHORT).show();
    }

    public void showCategories(List<Category> categories) {
        categoryAdapter.setCategories(categories);
    }

    public void showMeal(Meal meal) {
        toDayMeal = meal;
        editor.putString(Utils.TO_DAY_MEAL, getDay());
        editor.putString(Utils.MEAL_ID, toDayMeal.getIdMeal());
        editor.commit();
        updateToDayMeal();
    }
}
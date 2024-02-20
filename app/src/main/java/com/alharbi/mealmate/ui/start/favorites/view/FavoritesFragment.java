package com.alharbi.mealmate.ui.start.favorites.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alharbi.mealmate.R;
import com.alharbi.mealmate.datasource.database.MealLocalDataSourceImp;
import com.alharbi.mealmate.datasource.network.MealRemoteDataSourceImp;
import com.alharbi.mealmate.model.Meal;
import com.alharbi.mealmate.model.MealRepositoryImp;
import com.alharbi.mealmate.ui.start.favorites.presenter.FavoritesPresenter;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class FavoritesFragment extends Fragment {

    private RecyclerView rvFavorites;
    private TextInputEditText etSearch;
    private FavoritesAdapter favoritesAdapter;
    private FavoritesPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etSearch = view.findViewById(R.id.etSearch);

        rvFavorites = view.findViewById(R.id.rvFavorites);
        rvFavorites.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        favoritesAdapter = new FavoritesAdapter(getContext(), new ArrayList<>());
        rvFavorites.setAdapter(favoritesAdapter);

        presenter = new FavoritesPresenter(this, MealRepositoryImp.getInstance(
                MealRemoteDataSourceImp.getInstance(),
                MealLocalDataSourceImp.getInstance(getContext().getApplicationContext())
        ));

        presenter.getData();

    }

    public void showMeals(List<Meal> result) {
        favoritesAdapter.setMeals(result);

        Observable<Meal> observable = Observable.fromIterable(result);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String search = s.toString();
                List<Meal> list = new ArrayList<>();
                observable.filter(meal -> meal.getStrMeal().toLowerCase().contains(search.toLowerCase()))
                        .subscribe(meal -> list.add(meal),
                                e -> Log.i("TAG", "onCreate: " + e.getMessage()),
                                () -> favoritesAdapter.setMeals(list));
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    public void showError(String errorMsg) {
        Log.e("TAG", "showError: " + errorMsg);
        Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
    }
}
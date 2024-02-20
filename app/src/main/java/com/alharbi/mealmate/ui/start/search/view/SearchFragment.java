package com.alharbi.mealmate.ui.start.search.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
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
import com.alharbi.mealmate.model.Utils;
import com.alharbi.mealmate.ui.start.search.presenter.SearchPresenter;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class SearchFragment extends Fragment {

    private TextInputEditText searchView;
    private ChipGroup chipGroup;
    private RecyclerView rvSearch;
    private ProgressBar searchLoading;
    private SearchAdapter searchAdapter;
    private SearchPresenter presenter;
    private int type;
    private Observable<Meal> mealObservable;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        searchView = view.findViewById(R.id.searchView);
        chipGroup = view.findViewById(R.id.chipGroup);
        rvSearch = view.findViewById(R.id.rvSearch);
        searchLoading = view.findViewById(R.id.searchLoading);

        setupRecyclerView();
        setupChipGroup();

        presenter = new SearchPresenter(this, MealRepositoryImp.getInstance(
                MealRemoteDataSourceImp.getInstance(), MealLocalDataSourceImp.getInstance(getContext().getApplicationContext())
        ));

        type = Utils.NA;
    }

    private void setupRecyclerView() {
        searchAdapter = new SearchAdapter(getActivity(), new ArrayList<>());

        rvSearch.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        rvSearch.setAdapter(searchAdapter);
    }

    private void setupChipGroup() {
        for (int i = 0; i < chipGroup.getChildCount(); i++) {
            Chip chip = (Chip) chipGroup.getChildAt(i);
            int finalI = i;
            chip.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    Utils.showProgressBar(searchLoading);
                    switch (finalI) {
                        case 0:
                            type = Utils.FILTER_BY_CATEGORY;
                            presenter.getData(Utils.LIST_CATEGORIES);
                            break;
                        case 1:
                            type = Utils.FILTER_BY_AREA;
                            presenter.getData(Utils.LIST_AREAS);
                            break;
                        case 2:
                            type = Utils.FILTER_BY_INGREDIENT;
                            presenter.getData(Utils.LIST_INGREDIENTS);
                            break;
                        default:
                    }
                }
            });
        }
    }

    public void showMeals(List<Meal> result) {
        Utils.hideProgressBar(searchLoading);

        searchAdapter.setMeals(result, type);

        mealObservable = Observable.fromIterable(result);
        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String search = s.toString();
                List<Meal> list = new ArrayList<>();
                mealObservable.filter(meal -> {
                            String data;
                            if (type == Utils.FILTER_BY_INGREDIENT) {
                                data = meal.getStrIngredient();
                            } else if (type == Utils.FILTER_BY_CATEGORY) {
                                data = meal.getStrCategory();
                            } else if (type == Utils.FILTER_BY_AREA) {
                                data = meal.getStrArea();
                            } else {
                                data = "";
                            }
                            return data.toLowerCase().contains(search.toLowerCase());
                        })
                        .subscribe(meal -> list.add(meal),
                                e -> Log.i("TAG", "onCreate: " + e.getMessage()),
                                () -> searchAdapter.setMeals(list, type));
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
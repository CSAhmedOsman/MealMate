package com.alharbi.mealmate.ui.searchresult.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alharbi.mealmate.R;
import com.alharbi.mealmate.datasource.database.MealLocalDataSourceImp;
import com.alharbi.mealmate.datasource.network.MealRemoteDataSourceImp;
import com.alharbi.mealmate.model.Meal;
import com.alharbi.mealmate.model.MealRepositoryImp;
import com.alharbi.mealmate.model.Utils;
import com.alharbi.mealmate.ui.searchresult.presenter.SearchResultPresenter;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class SearchResultActivity extends AppCompatActivity {

    private RecyclerView rvSearchResult;
    private ResultAdapter resultAdapter;
    private SearchResultPresenter presenter;
    private TextInputEditText etSearchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        etSearchResult = findViewById(R.id.etSearchResult);

        presenter = new SearchResultPresenter(this,
                MealRepositoryImp.getInstance(MealRemoteDataSourceImp.getInstance(),
                        MealLocalDataSourceImp.getInstance(getApplicationContext())));

        rvSearchResult = findViewById(R.id.rvSearchResult);
        rvSearchResult.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        resultAdapter = new ResultAdapter(this, new ArrayList<>());
        rvSearchResult.setAdapter(resultAdapter);

        Intent intent = getIntent();
        int type = intent.getIntExtra(Utils.FILTER_TYPE, Utils.NA);
        String data = intent.getStringExtra(Utils.FILTER_DATA);

        presenter.getData(type, data);
    }

    public void showMeals(List<Meal> result) {
        resultAdapter.setMeals(result);

        Observable<Meal> observable = Observable.fromIterable(result);
        etSearchResult.addTextChangedListener(new TextWatcher() {
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
                                () -> resultAdapter.setMeals(list));
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void showError(String errorMsg) {
        Log.e("TAG", "showError: " + errorMsg);
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }
}
package com.alharbi.mealmate.ui.mealdetails.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alharbi.mealmate.R;
import com.alharbi.mealmate.datasource.database.MealLocalDataSourceImp;
import com.alharbi.mealmate.datasource.network.MealRemoteDataSourceImp;
import com.alharbi.mealmate.model.Meal;
import com.alharbi.mealmate.model.MealRepositoryImp;
import com.alharbi.mealmate.model.Utils;
import com.alharbi.mealmate.ui.mealdetails.presenter.MealDetailsPresenter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class MealDetailsActivity extends AppCompatActivity {

    private ImageView imageMeal;
    private TextView tvArea;
    private TextView tvCategory;
    private TextView tvMealName;
    private RecyclerView rvIngredient_items;
    private TextView tvInstruction;
    private YouTubePlayerView youtubeMealPlayer;
    private MealDetailsPresenter presenter;
    private IngredientAdapter ingredientAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_details);

        imageMeal = findViewById(R.id.imageMealD);
        tvArea = findViewById(R.id.tvAreaD);
        tvCategory = findViewById(R.id.tvCategoryD);
        tvMealName = findViewById(R.id.tvMealNameD);
        tvInstruction = findViewById(R.id.tvInstructionD);

        youtubeMealPlayer = findViewById(R.id.youtubeMealD);

        rvIngredient_items = findViewById(R.id.rvIngredientsD);

        rvIngredient_items.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        ingredientAdapter = new IngredientAdapter(this, new Meal());
        rvIngredient_items.setAdapter(ingredientAdapter);

        presenter = new MealDetailsPresenter(this,
                MealRepositoryImp.getInstance(MealRemoteDataSourceImp.getInstance(),
                        MealLocalDataSourceImp.getInstance(getApplicationContext())));

        Intent intent = getIntent();

        String idMeal = intent.getStringExtra(Utils.MEAL_ID);
        int type = intent.getIntExtra(Utils.TYPE_MEAL_DETAILS, Utils.NA);

        presenter.getData(type, idMeal);
    }

    private void updateUi(Meal meal) {
        tvArea.setText(Utils.getFlagEmoji(meal.getStrArea()) + " " + meal.getStrArea());
        tvCategory.setText(meal.getStrCategory());
        tvMealName.setText(meal.getStrMeal());
        tvInstruction.setText(meal.getStrInstructions());

        youtubeMealPlayer.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                youTubePlayer.cueVideo(videoId(meal.getStrYoutube()), 0);
                youTubePlayer.pause();
            }
        });

        ingredientAdapter.setMeal(meal);

        Glide.with(this)
                .load(meal.getStrMealThumb())
                .apply(new RequestOptions().override(200, 200))
                .error(R.drawable.gradient_shape)
                .into(imageMeal);
    }

    private String videoId(String strYoutube) {
        String[] split = strYoutube.trim().split("v=");
        return split.length > 0 ? split[1] : "";
    }

    public void showData(Meal result) {
        updateUi(result);
    }

    public void showError(String errorMsg) {
        Log.i("TAG", "showError: " + errorMsg);
    }

}
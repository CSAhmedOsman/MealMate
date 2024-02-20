package com.alharbi.mealmate.ui.start.favorites.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alharbi.mealmate.R;
import com.alharbi.mealmate.model.Meal;
import com.alharbi.mealmate.model.Utils;
import com.alharbi.mealmate.ui.mealdetails.view.MealDetailsActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.MyViewHolder> {
    private List<Meal> meals;
    private MyViewHolder holder;
    private Context context;

    public FavoritesAdapter(Context context, List<Meal> meals) {
        this.context = context;
        this.meals = meals != null ? meals : new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_meal, parent, false);
        holder = new MyViewHolder(view);
        return holder;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals != null ? meals : new ArrayList<>();
        notifyDataSetChanged();
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        this.holder = holder;
        Meal meal = meals.get(position);
        if (meal != null) {
            holder.title.setText(meal.getStrMeal());

            holder.view.setOnClickListener(v -> {
                Intent view = new Intent(context, MealDetailsActivity.class);
                view.putExtra(Utils.MEAL_ID, meal.getIdMeal());
                view.putExtra(Utils.TYPE_MEAL_DETAILS, Utils.LOCAL_TYPE);
                context.startActivity(view);
            });

            Glide.with(context)
                    .load(meal.getStrMealThumb())
                    .apply(new RequestOptions().override(200, 200))
                    .error(R.drawable.gradient_shape)
                    .into(holder.photo);
        }
    }

    @Override
    public int getItemCount() {
        return (meals == null) ? 0 : meals.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView photo;
        TextView title;
        View view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            photo = itemView.findViewById(R.id.imageMeal);
            title = itemView.findViewById(R.id.tvMealName);
        }
    }
}

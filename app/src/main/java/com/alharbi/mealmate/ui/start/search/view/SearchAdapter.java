package com.alharbi.mealmate.ui.start.search.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import com.alharbi.mealmate.ui.searchresult.view.SearchResultActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {
    private List<Meal> meals;
    private MyViewHolder holder;
    private Context context;
    private int type;

    public SearchAdapter(Context context, List<Meal> meals) {
        type = Utils.NA;
        this.context = context;
        this.meals = meals != null ? meals : new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_search, parent, false);
        holder = new MyViewHolder(view);
        return holder;
    }

    public void setMeals(List<Meal> meals, int type) {
        this.type = type;
        this.meals = meals != null ? meals : new ArrayList<>();
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        this.holder = holder;
        Meal meal = meals.get(position);
        if (meal != null) {
            if (type != Utils.NA) {
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

                holder.title.setText(data);

                holder.view.setOnClickListener(v -> {
                    Intent view = new Intent(context, SearchResultActivity.class);
                    view.putExtra(Utils.FILTER_TYPE, type);
                    view.putExtra(Utils.FILTER_DATA, data);
                    context.startActivity(view);
                });

                drawImage(holder, data, type);
            }
        }
    }

    private void drawImage(MyViewHolder holder, String data, int type) {
        String url;
        if (type == Utils.FILTER_BY_INGREDIENT) {
            url = "https://www.themealdb.com/images/ingredients/" + data + ".png";
            getImage(holder, url);
        } else if (type == Utils.FILTER_BY_CATEGORY) {
            url = "https://www.themealdb.com/images/category/" + data.toLowerCase() + ".png";
            getImage(holder, url);
        } else if (type == Utils.FILTER_BY_AREA) {
            Drawable emojiDrawable = Utils.getDrawableFromEmoji(Utils.getFlagEmoji(data), holder.itemView);
            if (emojiDrawable != null) {
                holder.imageSearch.setImageDrawable(emojiDrawable);
            }
        }
    }

    private void getImage(MyViewHolder holder, String url) {
        Glide.with(context)
                .load(url)
                .apply(new RequestOptions().override(200, 200))
                .error(R.drawable.gradient_shape)
                .into(holder.imageSearch);
    }

    @Override
    public int getItemCount() {
        return (meals == null) ? 0 : meals.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imageSearch;
        View view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            title = itemView.findViewById(R.id.tvTitleSearch);
            imageSearch = itemView.findViewById(R.id.imageSearch);
        }
    }
}

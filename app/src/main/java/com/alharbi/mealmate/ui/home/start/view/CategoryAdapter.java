package com.alharbi.mealmate.ui.home.start.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alharbi.mealmate.R;
import com.alharbi.mealmate.model.Category;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private List<Category> categories;
    private MyViewHolder holder;
    private Context context;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories != null ? categories : new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_meal, parent, false);
        holder = new MyViewHolder(view);
        return holder;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories != null ? categories : new ArrayList<>();
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        this.holder = holder;
        Category category = categories.get(position);
        if (category != null) {
            holder.title.setText(category.getStrCategory());

            holder.view.setOnClickListener(v -> {

            });

            Glide.with(context)
                    .load(category.getStrCategoryThumb())
                    .apply(new RequestOptions().override(200, 200))
                    .error(R.drawable.gradient_shape)
                    .into(holder.photo);
        }
    }

    @Override
    public int getItemCount() {
        return (categories == null) ? 0 : categories.size();
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

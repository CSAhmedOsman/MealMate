package com.alharbi.mealmate.ui.mealdetails.view;

import android.content.Context;
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
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.MyViewHolder> {
    private Meal meal;
    private MyViewHolder holder;
    private Context context;

    public IngredientAdapter(Context context, Meal meal) {
        this.context = context;
        this.meal = meal != null ? meal : new Meal();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ingredient, parent, false);
        holder = new MyViewHolder(view);
        return holder;
    }

    public void setMeal(Meal meal) {
        this.meal = meal != null ? meal : new Meal();
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        this.holder = holder;
        String ingredientItem = Utils.getIngredients(meal).get(position);
        holder.title.setText(ingredientItem);
        holder.measure.setText(Utils.getMeasures(meal).get(position));
        loadImage(context, ingredientItem, holder);
    }

    @Override
    public int getItemCount() {
        return (meal == null) ? 0 : Utils.getIngredients(meal).size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView photo;
        TextView title;
        TextView measure;
        View view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            photo = itemView.findViewById(R.id.ingredientImage);
            title = itemView.findViewById(R.id.ingredientTitle);
            measure = itemView.findViewById(R.id.ingredientMeasure);
        }
    }

    public void loadImage(Context context, String uri, MyViewHolder holder) {
        String url = "https://www.themealdb.com/images/ingredients/" + uri + "-Small.png";
        Glide.with(context)
                .load(url)
                .apply(new RequestOptions().override(200, 200))
                .error(R.drawable.gradient_shape)
                .into(holder.photo);
    }
}

package com.example.getthewine.UI.Meal;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getthewine.Models.Meal;
import com.example.getthewine.Models.Wine;
import com.example.getthewine.R;
import com.example.getthewine.UI.Wine.WineTabs.SearchedWineRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MealsRecyclerViewAdapter extends RecyclerView.Adapter<MealsRecyclerViewAdapter.ViewHolder> {

    private List<Meal> mealList;
    private OnClickListener listener;

    public MealsRecyclerViewAdapter(){
        mealList = new ArrayList<>();
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
        notifyDataSetChanged();
    }

    public void setOnClickListener(OnClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.meal_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Resources resources = holder.itemView.getContext().getResources();
        String temp;

        holder.mealName.setText(mealList.get(position).getName());
        temp = String.format(resources.getString(R.string.remarks) + "\n%s", mealList.get(position).getRemarks());
        holder.mealRemarks.setText(temp);
        temp = String.format(resources.getString(R.string.affinity_with_the_chose_wine) + "\n%d", mealList.get(position).getScore());
        holder.mealScore.setText(temp);
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView mealName;
        private final TextView mealRemarks;
        private final TextView mealScore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mealName = itemView.findViewById(R.id.mealName);
            mealRemarks = itemView.findViewById(R.id.mealRemarks);
            mealScore = itemView.findViewById(R.id.mealScore);

            itemView.setOnClickListener(v -> {
                listener.onClick(mealList.get(getBindingAdapterPosition()));
            });
        }
    }
    public interface OnClickListener {
        void onClick(Meal meal);
    }
}

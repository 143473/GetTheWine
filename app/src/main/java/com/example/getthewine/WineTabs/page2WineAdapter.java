package com.example.getthewine.WineTabs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getthewine.API.WineApi;
import com.example.getthewine.Models.Wine;
import com.example.getthewine.R;

import java.util.ArrayList;
import java.util.List;

public class page2WineAdapter extends RecyclerView.Adapter<page2WineAdapter.ViewHolder> {

private List<Wine> wineList;
private View.OnClickListener listener;

public page2WineAdapter(){
    wineList = new ArrayList<>();
}

    public void setWineList(List<Wine> wineList) {
        this.wineList = wineList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.wine_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.wineName.setText(wineList.get(position).getName());
        holder.wineColor.setText(wineList.get(position).getColor());
        holder.wineCountry.setText(wineList.get(position).getProducer().getRegion().getCountry());
    }

    @Override
    public int getItemCount() {
        System.out.println(wineList.size());
        return wineList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView wineName;
        private final TextView wineColor;
        private final TextView wineCountry;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            wineName = itemView.findViewById(R.id.wineName);
            wineColor = itemView.findViewById(R.id.wineColor);
            wineCountry = itemView.findViewById(R.id.wineCountry);

//            itemView.setOnClickListener(v -> {
//                listener.onClick(pets.get(getBindingAdapterPosition()));
//            });
        }
    }
}

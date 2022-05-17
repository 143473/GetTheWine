package com.example.getthewine.UI.Wine.WineTabs;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getthewine.Models.Wine;
import com.example.getthewine.R;

import java.util.ArrayList;
import java.util.List;

public class FavoriteWineRecyclerViewAdapter extends RecyclerView.Adapter<FavoriteWineRecyclerViewAdapter.ViewHolder> {

    private List<Wine> wineList;
    private OnClickListener listener;

    public void setWineList(List<Wine> wineList) {
        this.wineList.clear();
        this.wineList = wineList;
        notifyDataSetChanged();
    }

    public FavoriteWineRecyclerViewAdapter(){
        wineList = new ArrayList<>();
    }

    public void setOnClickListener(OnClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.favourite_wine_item, parent, false);
        return new FavoriteWineRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteWineRecyclerViewAdapter.ViewHolder holder, int position) {
        Resources resources = holder.itemView.getContext().getResources();

        String text;
        System.out.println("the ---------------------------" + wineList.get(position).getGrapes());
        holder.name.setText(wineList.get(position).getName());
        text = String.format(resources.getString(R.string.color) + "\n%s", wineList.get(position).getColor());
        holder.color.setText(text);
        text = String.format(resources.getString(R.string.featured_grapes) + "\n%s", wineList.get(position).getGrapes().get(0));
        holder.grapes.setText(text);
        text = String.format(resources.getString(R.string.wine_region) + "\n%s", wineList.get(position).getRegion().toString());
        holder.wineRegion.setText(text);
        text = String.format(resources.getString(R.string.wine_producer) + "\n%s", wineList.get(position).getProducer());
        holder.producer.setText(text);
        text = String.format(resources.getString(R.string.potential_taste_tags) + "\n%s", wineList.get(position).getTaste_tags());
        holder.tasteTags.setText(text);
        text = String.format(resources.getString(R.string.potential_event_pairing) + "\n%s", wineList.get(position).getEvent_tags());
        holder.eventTags.setText(text);
        text = String.format(resources.getString(R.string.price_range) + "\n%s", wineList.get(position).getPrice_range());
        holder.priceRange.setText(text);
        text = String.format(resources.getString(R.string.lifespan) + "\n%d years", wineList.get(position).getLifespan());
        holder.lifespan.setText(text);
        text = String.format(resources.getString(R.string.optimal_drinking_temperature) + "\n%f", wineList.get(position).getOptimal_drinking_temperature().getCelsius());
        holder.drinkingTemperature.setText(text);
        text = String.format(resources.getString(R.string.wine_description) + "\n%s", wineList.get(position).getDescription());
        holder.description.setText(text);
    }

    @Override
    public int getItemCount() {
        return wineList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView name;
        private final TextView color;
        private final TextView grapes;
        private final TextView wineRegion;
        private final TextView producer;
        private final TextView tasteTags;
        private final TextView eventTags;
        private final TextView priceRange;
        private final TextView lifespan;
        private final TextView drinkingTemperature;
        private final TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.wineName1);
            color = itemView.findViewById(R.id.wineColor1);
            grapes = itemView.findViewById(R.id.grapes1);
            wineRegion = itemView.findViewById(R.id.wineRegion1);
            producer = itemView.findViewById(R.id.producer1);
            tasteTags = itemView.findViewById(R.id.tasteTags1);
            eventTags = itemView.findViewById(R.id.eventTags1);
            priceRange = itemView.findViewById(R.id.priceRange1);
            lifespan = itemView.findViewById(R.id.lifespan1);
            drinkingTemperature = itemView.findViewById(R.id.drinkingTemperature1);
            description = itemView.findViewById(R.id.wineDescription1);

            itemView.setOnClickListener(v -> {
                listener.onClick(wineList.get(getBindingAdapterPosition()));
            });
        }
    }
    public interface OnClickListener {
        void onClick(Wine wine);
    }
}

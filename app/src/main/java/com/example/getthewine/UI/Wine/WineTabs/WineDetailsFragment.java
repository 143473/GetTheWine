package com.example.getthewine.UI.Wine.WineTabs;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.getthewine.Models.Wine;
import com.example.getthewine.R;
import com.google.gson.Gson;

import java.util.Objects;

public class WineDetailsFragment extends Fragment {

    public static WineDetailsFragment newInstance() {
        return new WineDetailsFragment();
    }

    private View rootView = null;

    private TextView name;
    private TextView color;
    private TextView grapes;
    private TextView wineRegion;
    private TextView producer;
    private TextView tasteTags;
    private TextView eventTags;
    private TextView priceRange;
    private TextView lifespan;
    private TextView drinkingTemperature;
    private TextView description;

    private WineViewModel wineViewModel;

    public WineDetailsFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wineViewModel = new ViewModelProvider(this).get(WineViewModel.class);
        wineViewModel.searchForWine();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.wine_details_fragment, container, false);

        name = rootView.findViewById(R.id.wineName);
        color = rootView.findViewById(R.id.wineColor);
        grapes = rootView.findViewById(R.id.grapes);
        wineRegion = rootView.findViewById(R.id.wineRegion);
        producer = rootView.findViewById(R.id.producer);
        tasteTags = rootView.findViewById(R.id.tasteTags);
        eventTags = rootView.findViewById(R.id.eventTags);
        priceRange = rootView.findViewById(R.id.priceRange);
        lifespan = rootView.findViewById(R.id.lifespan);
        drinkingTemperature = rootView.findViewById(R.id.drinkingTemperature);
        description = rootView.findViewById(R.id.wineDescription);


        wineViewModel.getSearchedWine().observe(getViewLifecycleOwner(), wine -> {
            String text = "";
            name.setText(wine.getName());
            text = String.format(getResources().getString(R.string.color) + "\n%s", wine.getColor());
            color.setText(text);
            text = String.format(getResources().getString(R.string.featured_grapes) + "\n%s", wine.getGrapes());
            grapes.setText(text);
            text = String.format(getResources().getString(R.string.wine_region) + "\n%s", wine.getRegion());
            wineRegion.setText(text);
            text = String.format(getResources().getString(R.string.wine_producer) + "\n%s", wine.getProducer());
            producer.setText(text);
            text = String.format(getResources().getString(R.string.potential_taste_tags) + "\n%s", wine.getTaste_tags());
            tasteTags.setText(text);
            text = String.format(getResources().getString(R.string.potential_event_pairing) + "\n%s", wine.getEvent_tags());
            eventTags.setText(text);
            text = String.format(getResources().getString(R.string.price_range) + "\n%s", wine.getPrice_range());
            priceRange.setText(text);
            text = String.format(getResources().getString(R.string.lifespan) + "\n%d", wine.getLifespan());
            lifespan.setText(text);
            text = String.format(getResources().getString(R.string.optimal_drinking_temperature) + "\n%f", wine.getOptimal_drinking_temperature().getCelsius());
            drinkingTemperature.setText(text);
            text = String.format(getResources().getString(R.string.wine_description) + "\n%s", wine.getDescription());
            description.setText(text);
        });

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
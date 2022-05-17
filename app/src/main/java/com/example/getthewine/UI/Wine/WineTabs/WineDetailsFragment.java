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
    private TextView textView;

    private WineViewModel wineViewModel;

    public WineDetailsFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wineViewModel = new ViewModelProvider(this).get(WineViewModel.class);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
           int id = bundle.getInt("wineId");
            System.out.println(id);
            wineViewModel.searchForWine();
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.wine_details_fragment, container, false);
        textView = rootView.findViewById(R.id.text);
       // textView.setText(wineViewModel.getSearchedWine().toString());

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
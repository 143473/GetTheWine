package com.example.getthewine.UI.Wine.WineTabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.getthewine.R;
import com.example.getthewine.UI.Wine.WineViewModel;

public class FavoriteWineFragment extends Fragment {

  private WineViewModel wineViewModel;
    private View rootView;
    private RecyclerView recyclerView;

    public FavoriteWineFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wineViewModel = new ViewModelProvider(this).get(WineViewModel.class);
        wineViewModel.retrieveFavouriteWineList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_page3, container, false);
        recyclerView = rootView.findViewById(R.id.favouriteRecycleView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        FavoriteWineRecyclerViewAdapter recyclerViewAdapter = new FavoriteWineRecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);

        wineViewModel.getFavouriteWineList().observe(getViewLifecycleOwner(), wineList ->{
            recyclerViewAdapter.setWineList(wineList);
        });

        return rootView;
    }
}
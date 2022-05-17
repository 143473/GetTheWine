package com.example.getthewine.UI.Wine.WineTabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.example.getthewine.R;
import com.example.getthewine.UI.Wine.WineViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class SearchByNameFragment extends Fragment {

    private WineViewModel wineViewModel;
    private View rootView = null;

    private TextInputEditText editText;

    private RecyclerView recyclerView;

    public SearchByNameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wineViewModel = new ViewModelProvider(this).get(WineViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_page2, container, false);
        editText = rootView.findViewById(R.id.textInputField);
        recyclerView = rootView.findViewById(R.id.recycleView);

        SearchedWineRecyclerViewAdapter recyclerViewAdapter= new SearchedWineRecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerViewAdapter.setOnClickListener(wine -> {
            goToDetailsFragment(wine.getId());
        });

        wineViewModel.getSearchedWineList().observe(getViewLifecycleOwner(), wineList ->{
            recyclerViewAdapter.setWineList(wineList);
        } );

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                if (event == null) {
                    if (actionId == EditorInfo.IME_ACTION_NEXT) {
                        searchForWineList();
                        return true;
                    }
                }
                return false;
            }
            });
        return rootView;
    }

    public void searchForWine(){
        wineViewModel.searchForWine();
    }

    public void searchForWineList(){
        wineViewModel.searchForWineList();
    }

    public void goToDetailsFragment(int id){
        wineViewModel.searchForWine();
        NavHostFragment.findNavController(this).navigate(R.id.action_mainWineFragment_to_wineDetailsFragment3);
    }
}
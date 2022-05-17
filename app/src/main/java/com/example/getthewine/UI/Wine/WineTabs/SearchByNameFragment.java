package com.example.getthewine.UI.Wine.WineTabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.example.getthewine.R;
import com.example.getthewine.Repo.WineRepository;
import com.google.android.material.textfield.TextInputEditText;

public class SearchByNameFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private WineViewModel wineViewModel;
    private View rootView = null;

    private TextInputEditText editText;

    private RecyclerView recyclerView;

    public SearchByNameFragment() {
        // Required empty public constructor
    }

    public static SearchByNameFragment newInstance(String param1, String param2) {
        SearchByNameFragment fragment = new SearchByNameFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        wineViewModel = new ViewModelProvider(this).get(WineViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_page2, container, false);
        editText = rootView.findViewById(R.id.textInputField);
        recyclerView = rootView.findViewById(R.id.recycleView);

        WineRecyclerViewAdapter  recyclerViewAdapter= new WineRecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerViewAdapter.setOnClickListener(wine -> {
            //wineViewModel.setWineId(wine.getId());
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

            Fragment fragment = new Fragment();
            Bundle bundle = new Bundle();
            bundle.putInt("wineId", id);
            fragment.setArguments(bundle);

        NavHostFragment.findNavController(this).navigate(R.id.action_mainWineFragment_to_wineDetailsFragment3);
    }
}
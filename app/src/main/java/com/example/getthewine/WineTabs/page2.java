package com.example.getthewine.WineTabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.getthewine.Models.Wine;
import com.example.getthewine.R;
import com.example.getthewine.Repo.WineRepository;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link page2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class page2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private WineRepository repository;

    private View rootView = null;
    private Button searchButton;

    private TextInputEditText editText;
    private TextView textView;

    private page2WineAdapter wineAdapter;
    private RecyclerView recyclerView;

    public page2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment page2.
     */
    // TODO: Rename and change types and number of parameters
    public static page2 newInstance(String param1, String param2) {
        page2 fragment = new page2();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_page2, container, false);

        repository = WineRepository.getInstance();

        editText = rootView.findViewById(R.id.textInputField);
        searchButton = rootView.findViewById(R.id.searchButton);

        recyclerView = rootView.findViewById(R.id.recycleView);
        wineAdapter = new page2WineAdapter();
        recyclerView.setAdapter(wineAdapter);

        repository.getSearchedWineList().observe(getViewLifecycleOwner(), wineList ->{
            wineAdapter.setWineList(wineList);
        } );


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchForWineList();
            }
        });

        return rootView;
    }

    public void searchForWine(){
        repository.searchForWine();
    }

    public void searchForWineList(){
        repository.searchForWineList();
    }
}
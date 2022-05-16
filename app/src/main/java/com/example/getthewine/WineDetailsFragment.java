package com.example.getthewine;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.getthewine.Models.Wine;
import com.google.gson.Gson;

public class WineDetailsFragment extends Fragment {

    public static WineDetailsFragment newInstance() {
        return new WineDetailsFragment();
    }

    private WineDetailsViewModel mViewModel;
    private View rootView = null;
    private TextView textView;

    public WineDetailsFragment(){

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.wine_details_fragment, container, false);

        String jsonWineObject = null;
        Bundle extras = getActivity().getIntent().getExtras();
        if(extras !=null){
            jsonWineObject = extras.getString("wine");
        }
        textView = rootView.findViewById(R.id.textView);
        Wine wine = new Gson().fromJson(jsonWineObject, Wine.class);
        textView.setText(wine.getName());
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(WineDetailsViewModel.class);
        // TODO: Use the ViewModel
    }

}
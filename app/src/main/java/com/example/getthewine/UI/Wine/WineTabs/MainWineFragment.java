package com.example.getthewine.UI.Wine.WineTabs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.getthewine.R;
import com.example.getthewine.UI.Auth.SignInActivity;
import com.example.getthewine.UI.Auth.UserViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainWineFragment extends Fragment {

    private TabLayout tabs;
    private ViewPager2 viewPager2;
    private WineViewModel wineViewModel;
    private UserViewModel userViewModel;

    private View rootView = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        wineViewModel = new ViewModelProvider(this).get(WineViewModel.class);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.main_wine_fragment, container, false);



        tabs = rootView.findViewById(R.id.tabs);
        viewPager2 = rootView.findViewById(R.id.viewPager);

        ViewPageTabAdapter adapter = new ViewPageTabAdapter(this.getActivity());
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabs, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Search by Name");
                        break;
                    case 1:
                        tab.setText("Scan Label");
                        break;
                    case 2:
                        tab.setText("Wine Info");
                        break;
                }
            }
        }).attach();
        return rootView;
    }
}

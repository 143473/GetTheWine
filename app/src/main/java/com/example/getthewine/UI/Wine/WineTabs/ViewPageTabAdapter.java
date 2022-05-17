package com.example.getthewine.UI.Wine.WineTabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPageTabAdapter extends FragmentStateAdapter {

    public ViewPageTabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new ScanLabelFragment();
            case 2:
                return new FavoriteWineFragment();
            default:
                return new SearchByNameFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

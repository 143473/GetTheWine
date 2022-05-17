package com.example.getthewine.UI.Wine.WineTabs;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.getthewine.Models.Wine;
import com.example.getthewine.Repo.UserRepository;
import com.example.getthewine.Repo.WineRepository;

import java.util.List;

public class WineViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private WineRepository wineRepository;
    private int id;

    public WineViewModel(@NonNull Application application) {
        super(application);

        userRepository = UserRepository.getInstance(application);
        wineRepository = WineRepository.getInstance(application);
    }

    public LiveData<List<Wine>> getSearchedWineList() {
        return wineRepository.getSearchedWineList();
    }

    public LiveData<Wine> getSearchedWine() {
        return wineRepository.getSearchedWine();
    }

    public void searchForWine() {
       wineRepository.searchForWine();
    }

    public void searchForWineList() {
       wineRepository.searchForWineList();
    }

    public void setWineId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

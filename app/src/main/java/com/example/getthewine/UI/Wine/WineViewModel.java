package com.example.getthewine.UI.Wine;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.getthewine.DAO.DAOWine;
import com.example.getthewine.Models.Wine;
import com.example.getthewine.Repo.UserRepository;
import com.example.getthewine.Repo.WineRepository;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class WineViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private WineRepository wineRepository;
    private DAOWine daoWine;
    private Fragment temp;
    private int id;
    private MutableLiveData<List<Wine>> favouriteWineList;
    private DatabaseReference databaseReference;

    public WineViewModel(@NonNull Application application) {
        super(application);

        userRepository = UserRepository.getInstance(application);
        wineRepository = WineRepository.getInstance(application);
        wineRepository.init();
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

    public void addWineToFavorites(Wine wine){
        wineRepository.addWineToFavorites(wine);
    }

    public Fragment getTemp() {
        return temp;
    }

    public void setTemp(Fragment temp) {
        this.temp = temp;
    }

    public LiveData<List<Wine>> getFavouriteWineList() {
        return wineRepository.getFavouriteWineList();
    }

    public void retrieveFavouriteWineList() {
        wineRepository.retrieveFavouriteWineList();
    }
}

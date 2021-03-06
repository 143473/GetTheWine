package com.example.getthewine.Repo;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.getthewine.API.ServiceGenerator;
import com.example.getthewine.API.WineApi;
import com.example.getthewine.API.WineResponse;
import com.example.getthewine.DAO.DAOWine;
import com.example.getthewine.DAO.WineLiveData;
import com.example.getthewine.Models.Wine;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class WineRepository {

    private static WineRepository instance;
    private Application application;
    private DAOWine daoWine;

    private final MutableLiveData<Wine> searchedWine;
    private final MutableLiveData<List<Wine>> searchedWineList;

    private DatabaseReference databaseReference;
    private MutableLiveData<List<Wine>> favouriteWineList;
    private WineLiveData wine;

    private WineRepository(Application application) {
        daoWine = new DAOWine(application);
        this.application = application;
        searchedWine = new MutableLiveData<>();
        searchedWineList = new MutableLiveData<>();
        favouriteWineList = new MutableLiveData<>();
    }

    public void init() {
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://getthewine-24c27-default-rtdb.europe-west1.firebasedatabase.app/");
        databaseReference = database.getReference().child("data");
        wine = new WineLiveData(databaseReference);
    }

    public static synchronized WineRepository getInstance(Application application) {
        if (instance == null) {
            instance = new WineRepository(application);
        }
        return instance;
    }

    public LiveData<Wine> getSearchedWine() {
        return searchedWine;
    }

    public LiveData<List<Wine>> getSearchedWineList(){
        return searchedWineList;
    }

    public void searchForWine() {
        WineApi wineApi = ServiceGenerator.getWineApi();
        Call<WineResponse> call = wineApi.getWineHardCodedById();
        call.enqueue(new Callback<WineResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<WineResponse> call, Response<WineResponse> response) {
                if (response.isSuccessful() && response.body()!= null) {
                    searchedWine.setValue(response.body().getDetailedWine());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<WineResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }

    public void searchForWineList() {
            WineApi wineApi = ServiceGenerator.getWineApi();
            Call<List<WineResponse>> call = wineApi.getSearchedWineListCoded();
            call.enqueue(new Callback<List<WineResponse>>() {
                @EverythingIsNonNull
                @Override
                public void onResponse(Call<List<WineResponse>> call, Response<List<WineResponse>> response) {
                    if (response.isSuccessful() && response.body()!= null) {
                        List<Wine> wineList = new ArrayList<>();
                        for (int i = 0; i < response.body().size(); i++) {
                            wineList.add(response.body().get(i).getWine());
                        }
                        searchedWineList.setValue(wineList);
                    }
                }
                @EverythingIsNonNull
                @Override
                public void onFailure(Call<List<WineResponse>> call, Throwable t) {
                    Log.i("Retrofit", "Something went wrong :(");
                }
            });
    }

    public void retrieveFavouriteWineList() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Wine> wines = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Wine wine = dataSnapshot.getValue(Wine.class);
                    wines.add(wine);
                }
                favouriteWineList.setValue(wines);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public LiveData<List<Wine>> getFavouriteWineList() {
        return favouriteWineList;
    }

    public void addWineToFavorites(Wine wine) {
        daoWine.addWineToFavorites(wine);
    }
}

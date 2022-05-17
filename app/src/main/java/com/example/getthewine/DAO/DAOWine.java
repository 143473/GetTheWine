package com.example.getthewine.DAO;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.getthewine.Models.Wine;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class DAOWine {
    private DatabaseReference databaseReference;

    private Application application;

    public DAOWine(Application application) {
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://getthewine-24c27-default-rtdb.europe-west1.firebasedatabase.app/");
        databaseReference = database.getReference().child("data");
        this.application = application;
    }

    public void addWineToFavorites(Wine wine){
        databaseReference.child(Integer.toString(wine.getId())).setValue(new Wine(
                wine.getId(),
                wine.getName(),
                wine.getColor(),
                wine.getGrapes(),
                wine.getRegion(),
                wine.getProducer(),
                wine.getTaste_tags(),
                wine.getEvent_tags(),
                wine.getPrice_range(),
                wine.getLifespan(),
                wine.getOptimal_drinking_temperature(),
                wine.getDescription())).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                String message = "";
                if(task.isSuccessful()){
                    message = "This wine was successfully added to your collection";
                }
                else{
                    message = "Error while adding this wine to your collection";
                }
                Toast.makeText( application.getApplicationContext(), message + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getFavouriteWineList() {
       databaseReference.child("data").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                String message = "";
                if(task.isSuccessful()){
                    message = "This wine was successfully added to your collection";
                }
                else{
                    message = "Error while adding this wine to your collection";
                }
                Toast.makeText( application.getApplicationContext(), message + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void removeWineFromFavourites(int id){
        databaseReference.child(Integer.toString(id)).setValue(null);
    }
}

package com.example.getthewine.Repo;

import android.app.Application;

import androidx.annotation.NonNull;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class UserRepository {

    private Application application;
    private static UserRepository instance;

    public UserRepository(Application application){
        this.application = application;
    }
    public static synchronized UserRepository getInstance(Application application) {
        if (instance == null) {
            instance = new UserRepository(application);
        }
        return instance;
    }

    public void signOut(){
        AuthUI.getInstance().signOut(application.getApplicationContext());
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        startLoginActivity();
//                    }
//                });
    }
}

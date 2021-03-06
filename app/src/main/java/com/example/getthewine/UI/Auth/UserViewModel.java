package com.example.getthewine.UI.Auth;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.getthewine.Repo.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class UserViewModel extends AndroidViewModel {

    private final UserRepository userRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = UserRepository.getInstance(application);
    }

    public void signOut(){
        userRepository.signOut();
    }

    public FirebaseUser getCurrentUser(){
        return userRepository.getCurrentUser();
    }
}

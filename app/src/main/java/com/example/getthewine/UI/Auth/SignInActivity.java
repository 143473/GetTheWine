package com.example.getthewine.UI.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.getthewine.UI.Wine.WineTabs.WineViewModel;
import com.example.getthewine.UI.WineMainActivity;
import com.example.getthewine.R;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class SignInActivity extends AppCompatActivity {
    private UserViewModel userViewModel;

    @Override
    public void onCreate(Bundle instanceState) {
        super.onCreate(instanceState);
        setContentView(R.layout.activity_sign_in);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        FirebaseUser currentUser = userViewModel.getCurrentUser();

        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build());

        Intent signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setLogo(R.mipmap.ic_logo_foreground)
                .build();

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if(currentUser == null){
                        if (result.getResultCode() == RESULT_OK) {
                            goToMainActivity();
                            Toast.makeText(this, "Welcome to GetTheWine", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(this, "SIGN IN CANCELLED", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        goToMainActivity();
                        Toast.makeText(this, "Welcome back " + currentUser.getDisplayName(), Toast.LENGTH_SHORT).show();
                    }


                });

        activityResultLauncher.launch(signInIntent);
    }

    private void goToMainActivity() {
        Intent mainIntent = new Intent(this, WineMainActivity.class);
        startActivity(mainIntent);
        finish();
    }

}

package com.example.getthewine.UI.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.getthewine.UI.Wine.WineTabs.WineMainActivity;
import com.example.getthewine.R;
import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;
import java.util.List;

public class SignInActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle instanceState) {
        super.onCreate(instanceState);
        setContentView(R.layout.activity_sign_in);

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
                    if (result.getResultCode() == RESULT_OK)
                        goToMainActivity();
                    else
                        Toast.makeText(this, "SIGN IN CANCELLED", Toast.LENGTH_SHORT).show();
                });


        activityResultLauncher.launch(signInIntent);
    }

    private void goToMainActivity() {
        Intent mainIntent = new Intent(this, WineMainActivity.class);
        startActivity(mainIntent);
    }

}

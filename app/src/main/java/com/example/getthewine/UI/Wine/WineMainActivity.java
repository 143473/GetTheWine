package com.example.getthewine.UI.Wine;
import static androidx.navigation.ui.NavigationUI.setupActionBarWithNavController;

import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.getthewine.UI.Auth.SignInActivity;
import com.example.getthewine.R;
import com.example.getthewine.UI.Auth.UserViewModel;
import com.example.getthewine.UI.Wine.WineViewModel;
import com.example.getthewine.databinding.ActivityMainBinding;

public class WineMainActivity extends AppCompatActivity{

    private ActivityMainBinding binding;
    private AppBarConfiguration appBarConfiguration;

    private WineViewModel wineViewModel;
    private UserViewModel userViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wineViewModel = new ViewModelProvider(this).get(WineViewModel.class);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        setupActionBarWithNavController(this, navController);
    }

    @Override public boolean onSupportNavigateUp()
    {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.action_signOut){
            signOut();
            Toast.makeText(this, "You were successfully signed out.", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    private void startLoginActivity(){
        Intent signInIntent = new Intent(this, SignInActivity.class);
        startActivity(signInIntent);
        finish();
    }

    private void signOut(){
        userViewModel.signOut();
        startLoginActivity();
    }
}
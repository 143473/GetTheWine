package com.example.getthewine.UI;
import static androidx.navigation.ui.NavigationUI.setupActionBarWithNavController;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.getthewine.UI.Auth.SignInActivity;
import com.example.getthewine.R;
import com.example.getthewine.UI.Auth.UserViewModel;
import com.example.getthewine.UI.Wine.WineTabs.ViewPageTabAdapter;
import com.example.getthewine.UI.Wine.WineTabs.WineViewModel;
import com.example.getthewine.databinding.ActivityMainBinding;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WineMainActivity extends AppCompatActivity{

    private ActivityMainBinding binding;
    private AppBarConfiguration appBarConfiguration;
    private TabLayout tabs;
    private ViewPager2 viewPager2;
    private WineViewModel wineViewModel;
    private UserViewModel userViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wineViewModel = new ViewModelProvider(this).get(WineViewModel.class);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // Get the navigation host fragment from this Activity
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
// Instantiate the navController using the NavHostFragment
        NavController navController = navHostFragment.getNavController();
         appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
// Make sure actions in the ActionBar get propagated to the NavController
        setupActionBarWithNavController(this, navController);

//
//        tabs = findViewById(R.id.tabs);
//        viewPager2 = findViewById(R.id.viewPager);
//
//        ViewPageTabAdapter adapter = new ViewPageTabAdapter(this);
//        viewPager2.setAdapter(adapter);
//
//        new TabLayoutMediator(tabs, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
//            @Override
//            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
//               switch (position){
//                   case 0:
//                       tab.setText("Search by Name");
//                       break;
//                   case 1:
//                       tab.setText("Scan Label");
//                       break;
//                   case 2:
//                       tab.setText("Wine Info");
//                       break;
//               }
//            }
//        }).attach();
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

        if (item.getItemId()==R.id.action_favorite){
            Toast.makeText(this, "Mmmm my precious!!", Toast.LENGTH_SHORT).show();
        }

        if (item.getItemId()==R.id.action_settings){
            Toast.makeText(this, "What settings?", Toast.LENGTH_SHORT).show();
        }

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
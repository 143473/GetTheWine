package com.example.getthewine.WineTabs;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.getthewine.Auth.SignInActivity;
import com.example.getthewine.R;
import com.example.getthewine.WineTabs.ViewPageAdapter;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity{

    private TabLayout tabs;
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tabs = findViewById(R.id.tabs);
        viewPager2 = findViewById(R.id.viewPager);

        ViewPageAdapter adapter = new ViewPageAdapter(this);
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabs, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
               switch (position){
                   case 0:
                       tab.setText("by Camera");
                       break;
                   case 1:
                       tab.setText("by Name");
                       break;
                   case 2:
                       tab.setText("by Meal");
                       break;
               }
            }
        }).attach();
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

    public void signOut(){
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        startLoginActivity();
                    }
                });
    }

    private void startLoginActivity(){
        Intent signInIntent = new Intent(this, SignInActivity.class);
        startActivity(signInIntent);
    }
}
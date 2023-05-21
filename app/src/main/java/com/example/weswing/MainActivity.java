package com.example.weswing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

import com.example.weswing.databinding.ActivityMainBinding;
import com.example.weswing.fragments.CalendarFragment;
import com.example.weswing.fragments.ChatFragment;
import com.example.weswing.fragments.FeedFragment;
import com.example.weswing.fragments.PromoteFragment;
import com.example.weswing.fragments.StarFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbarTitle = findViewById(R.id.toolbar_title);
        replaceFragment(new FeedFragment());
        bottomNavSelected();
    }


    public void bottomNavSelected(){
        binding.bottomNavigation.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.page_1:
                    replaceFragment(new FeedFragment());
                    break;
                case R.id.page_2:
                    replaceFragment(new PromoteFragment());
                    break;
                case R.id.page_3:
                    replaceFragment(new StarFragment());
                    break;
                case R.id.page_4:
                    replaceFragment(new CalendarFragment());
                    break;
                case R.id.page_5:
                    replaceFragment(new ChatFragment());
                    break;
            }
            return  true;
        });
    }

    public void replaceFragment(Fragment frahment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment,frahment);
        fragmentTransaction.commit();

    }

    public void changeTitle(String text){
        toolbarTitle.setText(text);
    }
}
    package com.rahulsrenj.phonebook.activities;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.rahulsrenj.phonebook.fragments.ContactsFragment;
import com.rahulsrenj.phonebook.fragments.FavoriteFragment;
import com.rahulsrenj.phonebook.adapters.FragmentAdapter;
import com.rahulsrenj.phonebook.handlers.MainActivityClickHandlers;
import com.rahulsrenj.phonebook.R;
import com.rahulsrenj.phonebook.databinding.ActivityMainBinding;

    public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private FragmentAdapter fragmentAdapter;
    private Toolbar toolbar;
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        viewPager2=binding.viewPager;
        tabLayout=binding.tabLayout;

        //Fragment Setup
        fragmentAdapter=new FragmentAdapter(getSupportFragmentManager(),getLifecycle());
        fragmentAdapter.addFragment(new ContactsFragment());
        fragmentAdapter.addFragment(new FavoriteFragment());
        viewPager2.setAdapter(fragmentAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position==0)
                {
                    tab.setIcon(R.drawable.contacts);

                }
                else{
                    tab.setIcon(R.drawable.favorites_filled);
                }
            }
        }).attach();

        binding.setClickHandler(new MainActivityClickHandlers(this));

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


    }
}
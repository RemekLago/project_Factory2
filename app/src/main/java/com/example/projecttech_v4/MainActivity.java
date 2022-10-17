package com.example.projecttech_v4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);

        tabLayout.addTab(tabLayout.newTab().setText("Maszyna01"));
        tabLayout.addTab(tabLayout.newTab().setText("Maszyna02"));
        tabLayout.addTab(tabLayout.newTab().setText("Maszyna03"));
        tabLayout.addTab(tabLayout.newTab().setText("Maszyna04"));
        tabLayout.addTab(tabLayout.newTab().setText("Maszyna05"));
        tabLayout.addTab(tabLayout.newTab().setText("Maszyna06"));

        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new PagerAdapter(fragmentManager, getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position){
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        Spinner spinner1 = findViewById(R.id.spinner1_operator);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource
                (getApplicationContext(), R.array.operator, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
//
//        Spinner spinner2 = findViewById(R.id.spinner2_data);
//        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource
//                (this, R.array.operator, android.R.layout.simple_spinner_item);
//
//        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner2.setAdapter(adapter1);
//        spinner2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
//
//        Spinner spinner3 = findViewById(R.id.spinner3_godzina);
//        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource
//                (this, R.array.operator, android.R.layout.simple_spinner_item);
//
//        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner3.setAdapter(adapter1);
//        spinner3.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

    }
}
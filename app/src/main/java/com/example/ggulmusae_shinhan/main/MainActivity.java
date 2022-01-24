package com.example.ggulmusae_shinhan.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.ggulmusae_shinhan.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private Fragment1 fragment1, fragment2, fragment3;
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTab();
    }


    private void initTab() {
        fragment1 = new Fragment1();
        fragment2 = new Fragment1();
        fragment3 = new Fragment1();

        getSupportFragmentManager().beginTransaction().add(R.id.container,fragment1).commit();

        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("사지말껄"));
        tabs.addTab(tabs.newTab().setText("팔지말껄"));
        tabs.addTab(tabs.newTab().setText("잘했어"));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                Fragment selected = fragment1;
                switch (position){
                    case 1:
                        selected = fragment2;
                        break;
                    case 2:
                        selected = fragment3;
                        break;
                    default:
                        selected = fragment1;
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();

            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}

package com.example.ggulmusae_shinhan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    TabLayout tabs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



////      fragment 실행을 위한 부분
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        final Bundle bundle = new Bundle();

        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("사지말껄"));
        tabs.addTab(tabs.newTab().setText("팔지말껄"));
        tabs.addTab(tabs.newTab().setText("잘했어"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                Fragment selected = null;

                if (position == 0)
                    selected = fragment1;
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();

                if (position == 1)
                    selected = fragment2;
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
                if (position == 2)
                    selected = fragment3;
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

    public void onClick(View v){
        switch(v.getId()){
            case R.id.card:
                startActivity(new Intent(this, PopupActivity.class));
        }
    }


}

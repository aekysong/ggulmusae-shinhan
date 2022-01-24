package com.example.ggulmusae_shinhan.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ggulmusae_shinhan.R;

public class Fragment3 extends Fragment {
    private Fragment3Listener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main,container,false);

        return rootView;
    }

    public interface Fragment3Listener{
        void onInputSent(String sector, String stockName, Double amount, Double rate);

    }
}
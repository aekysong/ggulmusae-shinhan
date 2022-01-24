package com.example.ggulmusae_shinhan.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ggulmusae_shinhan.R;

public class Fragment1 extends Fragment {
    private Fragment1Listener listener;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main,container,false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.frag_list);
        recyclerView.setHasFixedSize(true);
        recyclerAdapter = new RecyclerAdapter(getActivity(), 1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerAdapter);

        return rootView;
    }

    public interface Fragment1Listener{
        void onInputSent(String sector, String stockName, Double amount, Double rate);

    }
}

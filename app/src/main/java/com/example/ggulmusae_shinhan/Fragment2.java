package com.example.ggulmusae_shinhan;

import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    private Fragment2Listener listener;

    public interface Fragment2Listener{
        void onInputSent(String sector, String stockName, Double amount, Double rate);

    }
}
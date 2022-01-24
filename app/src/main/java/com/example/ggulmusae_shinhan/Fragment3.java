package com.example.ggulmusae_shinhan;

import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {
    private Fragment3Listener listener;

    public interface Fragment3Listener{
        void onInputSent(String sector, String stockName, Double amount, Double rate);

    }
}
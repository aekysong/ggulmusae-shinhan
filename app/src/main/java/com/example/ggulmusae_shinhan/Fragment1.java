package com.example.ggulmusae_shinhan;

import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    private Fragment1Listener listener;

    public interface Fragment1Listener{
        void onInputSent(String sector, String stockName, Double amount, Double rate);

    }
}

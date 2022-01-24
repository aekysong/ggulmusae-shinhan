package com.example.ggulmusae_shinhan.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ggulmusae_shinhan.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MainBottomSheet extends BottomSheetDialogFragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottom_sheet, container, false);
        // view.findViewById(R.id.close_btn).setOnClickListener(v -> dismiss());

        return view;

    }
}

package com.febry.kelaslnt;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class TestFragmentSatu extends Fragment {


    public Button buttonTest;

    public TestFragmentSatu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_satu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonTest = view.findViewById(R.id.button);

        buttonTest.setOnClickListener(view1 -> {
            Toast.makeText(getContext(), "Button diclick", Toast.LENGTH_SHORT).show();
        });
    }
}
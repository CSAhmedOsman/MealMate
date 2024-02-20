package com.alharbi.mealmate.ui.start;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alharbi.mealmate.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlansFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlansFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plans, container, false);
    }
}
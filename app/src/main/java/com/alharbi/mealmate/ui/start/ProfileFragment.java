package com.alharbi.mealmate.ui.start;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alharbi.mealmate.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {

    private Button btnBackup;
    private Button btnSignout;
    private TextView textViewUsername;
    private TextView textViewEmail;
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewUsername = view.findViewById(R.id.textViewUsername);
        textViewEmail = view.findViewById(R.id.textViewEmail);
        btnSignout = view.findViewById(R.id.btnSignout);
        btnBackup = view.findViewById(R.id.btnBackup);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            textViewUsername.setText(currentUser.getDisplayName());
            textViewEmail.setText(currentUser.getEmail());
            btnBackup.setOnClickListener(v -> backup());
            btnSignout.setOnClickListener(v -> {
                mAuth.signOut();
            });
        } else {
            btnSignout.setVisibility(View.GONE);
        }

    }

    private void backup() {

    }
}
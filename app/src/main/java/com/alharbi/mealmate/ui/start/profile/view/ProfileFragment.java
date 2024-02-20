package com.alharbi.mealmate.ui.start.profile.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alharbi.mealmate.R;
import com.alharbi.mealmate.datasource.database.MealLocalDataSourceImp;
import com.alharbi.mealmate.datasource.network.MealRemoteDataSourceImp;
import com.alharbi.mealmate.model.MealRepositoryImp;
import com.alharbi.mealmate.ui.start.profile.presenter.ProfilePresenter;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {

    private Button btnBackup;
    private Button btnSignout;
    private TextView textViewUsername;
    private TextView textViewEmail;
    private ProfilePresenter presenter;

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

        presenter = new ProfilePresenter(this, MealRepositoryImp.getInstance(
                MealRemoteDataSourceImp.getInstance(),
                MealLocalDataSourceImp.getInstance(getContext().getApplicationContext())
        ));
    }

    private void backup() {

    }

    public void updateUi(FirebaseUser currentUser) {
        if (currentUser != null) {
            textViewUsername.setText(currentUser.getDisplayName());
            textViewEmail.setText(currentUser.getEmail());
            btnBackup.setOnClickListener(v -> backup());
            btnSignout.setOnClickListener(v -> {
                presenter.signOut();
            });
        } else {
            btnSignout.setVisibility(View.GONE);
            btnBackup.setVisibility(View.GONE);
        }
    }

    public void showError(String errorMsg) {
        Log.e("TAG", "showError: " + errorMsg);
        Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
    }

    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
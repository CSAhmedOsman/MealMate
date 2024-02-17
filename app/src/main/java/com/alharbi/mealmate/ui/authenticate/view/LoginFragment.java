package com.alharbi.mealmate.ui.authenticate.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.alharbi.mealmate.R;
import com.alharbi.mealmate.model.Utils;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginFragment extends Fragment {

    private FirebaseAuth mAuth;
    private ProgressBar loading;
    private TextInputEditText username;
    private TextInputEditText password;
    private Button btnSignin;
    private Button btnNotSignup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextInputLayout textInputLayoutPassword = view.findViewById(R.id.textInputLayoutPasswordSingUp);
        textInputLayoutPassword.setEndIconMode(TextInputLayout.END_ICON_PASSWORD_TOGGLE);

        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        loading = view.findViewById(R.id.loading);
        btnSignin = view.findViewById(R.id.btnSingin);
        btnNotSignup = view.findViewById(R.id.btnNotSignup);

        mAuth = FirebaseAuth.getInstance();

        // Check if user is signed in (non-null) and update UI accordingly.
        btnSignin.setOnClickListener(v -> {
            String email = username.getText().toString();
            String pass = password.getText().toString();
            signIn(email, pass);
        });

        btnNotSignup.setOnClickListener(v -> {
            NavDirections navDirections = LoginFragmentDirections.actionLoginFragmentToSignupFragment();
            NavHostFragment.findNavController(this).navigate(navDirections);
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Log.d("TAG", "onStart: " + currentUser.getUid());
            Utils.reload(mAuth, getActivity());
        }
    }

    private void signIn(String email, String password) {
        Log.d("TAG", "signIn:" + email);
        if (Utils.validateForm(this.username, this.password, null)) {
            Utils.showProgressBar(loading);
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(requireActivity(), task -> {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithEmail:success");
                            Toast.makeText(requireContext(), "Authentication success.", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            Utils.updateUI(user, getActivity());
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithEmail:failure", task.getException());
                            Toast.makeText(getContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                            Utils.updateUI(null, getActivity());
                        }
                        Utils.hideProgressBar(loading);
                    });
        }
    }
}
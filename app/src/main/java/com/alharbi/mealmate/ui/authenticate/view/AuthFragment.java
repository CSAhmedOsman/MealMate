package com.alharbi.mealmate.ui.authenticate.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.alharbi.mealmate.R;
import com.alharbi.mealmate.ui.home.view.HomeActivity;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthFragment extends Fragment {

    private Button btnSingUpEmail;
    private SignInButton btnGoogleSignIn;
    private LoginButton btnFacebookLogin;
    private Button btnLoginAccount;
    private Button btnGuest;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 9001;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_auth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnSingUpEmail = view.findViewById(R.id.btnSingUpEmail);
        btnGoogleSignIn = view.findViewById(R.id.btnGoogleSignIn);
        btnFacebookLogin = view.findViewById(R.id.btnFacebookLogin);
        btnLoginAccount = view.findViewById(R.id.btnLoginAccount);
        btnGuest = view.findViewById(R.id.btnGuest);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null)
            mAuth.signOut();

        btnSingUpEmail.setOnClickListener(v -> {
            NavDirections navDirections = AuthFragmentDirections.actionAuthFragmentToSignupFragment();
            NavHostFragment.findNavController(this).navigate(navDirections);
        });

        btnLoginAccount.setOnClickListener(v -> {
            NavDirections navDirections = AuthFragmentDirections.actionAuthFragmentToLoginFragment();
            NavHostFragment.findNavController(this).navigate(navDirections);
        });

        btnGuest.setOnClickListener(v -> {
            Intent intent = new Intent(AuthFragment.this.getActivity(), HomeActivity.class);
            intent.setAction(Intent.ACTION_VIEW);
            startActivity(intent);
        });

                /*
        BeginSignInRequest signInRequest = BeginSignInRequest.builder()
                .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                        .setSupported(true)
                        // Your server's client ID, not your Android client ID.
                        .setServerClientId(getString(R.string.default_web_client_id))
                        // Only show accounts previously used to sign in.
                        .setFilterByAuthorizedAccounts(true)
                        .build())
                .build();

        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().build();

        mGoogleSignInClient = GoogleSignIn.getClient(requireContext(), gso);

        btnSignin.setOnClickListener(v -> {
            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
            startActivityForResult(signInIntent, RC_SIGN_IN);
        });*/
    }
}
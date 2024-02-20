package com.alharbi.mealmate.ui.authenticate.view;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.alharbi.mealmate.R;
import com.alharbi.mealmate.model.Utils;
import com.alharbi.mealmate.ui.start.HomeActivity;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class AuthFragment extends Fragment {

    private ProgressBar progressBar;
    private Button btnSingUpEmail;
    private SignInButton btnGoogleSignIn;
    private LoginButton btnFacebookLogin;
    private Button btnLoginAccount;
    private Button btnGuest;
    private SignInClient signInClient;
    private FirebaseAuth mAuth;
    private static final int RC_SIGN_IN = 1001;
    private CallbackManager mCallbackManager;

    private final ActivityResultLauncher<IntentSenderRequest> signInLauncher = registerForActivityResult(
            new ActivityResultContracts.StartIntentSenderForResult(),
            result -> handleSignInResult(result.getData())
    );

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
        progressBar = view.findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();
        signInClient = Identity.getSignInClient(requireContext());
        mCallbackManager = CallbackManager.Factory.create();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null)
            mAuth.signOut();
        else {
            oneTapSignIn();
        }

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

        btnGoogleSignIn.setOnClickListener(v -> signInGoogle());

        btnFacebookLogin.setPermissions("email", "public_profile");
        /*
        btnFacebookLogin.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("TAG", "facebook:onSuccess:" + loginResult);
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d("TAG", "facebook:onCancel");
                Utils.updateUI(null, getActivity());
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("TAG", "facebook:onError", error);
                Utils.updateUI(null, getActivity());
            }
        });
        */
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Utils.updateUI(currentUser, getActivity());
    }


    private void handleSignInResult(Intent data) {
        try {
            // Google Sign In was successful, authenticate with Firebase
            SignInCredential credential = signInClient.getSignInCredentialFromIntent(data);
            String idToken = credential.getGoogleIdToken();
            Log.d("TAG", "firebaseAuthWithGoogle:" + credential.getId());
            firebaseAuthWithGoogle(idToken);
        } catch (ApiException e) {
            // Google Sign In failed, update UI appropriately
            Log.w("TAG", "Google sign in failed", e);
            Utils.updateUI(null, getActivity());
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        Utils.showProgressBar(progressBar);
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(requireActivity(), task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("TAG", "signInWithCredential:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Utils.updateUI(user, getActivity());
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("TAG", "signInWithCredential:failure", task.getException());
                        Snackbar.make(getView(), "Authentication Failed.",
                                Snackbar.LENGTH_SHORT).show();
                        Utils.updateUI(null, getActivity());
                    }

                    Utils.hideProgressBar(progressBar);
                });
    }

    private void signInGoogle() {
        GetSignInIntentRequest signInRequest = GetSignInIntentRequest.builder()
                .setServerClientId(getString(R.string.default_web_client_id))
                .build();

        signInClient.getSignInIntent(signInRequest)
                .addOnSuccessListener(pendingIntent -> launchSignIn(pendingIntent))
                .addOnFailureListener(e -> {
                    Log.e("TAG", "Google Sign-in failed", e);
                    Toast.makeText(requireContext(), "Google Sign-in failed: " + e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                });
    }

    private void oneTapSignIn() {
        // Configure One Tap UI
        BeginSignInRequest oneTapRequest = BeginSignInRequest.builder()
                .setGoogleIdTokenRequestOptions(
                        BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                                .setSupported(true)
                                .setServerClientId(getString(R.string.default_web_client_id))
                                .setFilterByAuthorizedAccounts(true)
                                .build()
                ).build();

        // Display the One Tap UI
        signInClient.beginSignIn(oneTapRequest)
                .addOnSuccessListener(beginSignInResult -> launchSignIn(beginSignInResult.getPendingIntent()))
                .addOnFailureListener(e -> {
                    // No saved credentials found. Launch the One Tap sign-up flow, or
                    // do nothing and continue presenting the signed-out UI.
                });
    }

    private void launchSignIn(PendingIntent pendingIntent) {
        try {
            IntentSenderRequest intentSenderRequest = new IntentSenderRequest.Builder(pendingIntent)
                    .build();
            signInLauncher.launch(intentSenderRequest);
        } catch (Exception e) {
            Toast.makeText(requireContext(), "Couldn't start Sign In: " + e.getLocalizedMessage(),
                    Toast.LENGTH_SHORT).show();
            Log.e("TAG", "Couldn't start Sign In: " + e.getLocalizedMessage());
        }
    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d("TAG", "handleFacebookAccessToken:" + token);
        Utils.showProgressBar(progressBar);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(requireActivity(), task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("TAG", "signInWithCredential:success");
                        Toast.makeText(getContext(), "signInWithCredential:success",
                                Toast.LENGTH_SHORT).show();
                        FirebaseUser user = mAuth.getCurrentUser();
                        Utils.updateUI(user, getActivity());
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("TAG", "signInWithCredential:failure", task.getException());
                        Toast.makeText(getContext(), "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                        Utils.updateUI(null, getActivity());
                    }
                    Utils.hideProgressBar(progressBar);
                });
    }

}
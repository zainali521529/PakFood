package com.example.pakfodies;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class SplashScreen extends AppCompatActivity {
    private static final int AUTH_REQUEST_CODE = 1212;
    private List<AuthUI.IdpConfig> mProviders = Arrays.asList(
            new AuthUI.IdpConfig.EmailBuilder().build(),
            new AuthUI.IdpConfig.PhoneBuilder().build()

    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        FirebaseAuth auth =FirebaseAuth.getInstance();
        FirebaseUser user =auth.getCurrentUser();

        if (user !=null){
            welcome();
        }else
            waitandgo();
    }

    private void waitandgo() {

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Authuser();
            }
        },5000);
    }

    private void Authuser() {
        Intent inntent = AuthUI.getInstance()
                .createSignInIntentBuilder().setAvailableProviders(mProviders)
                .build();
        startActivityForResult(inntent, AUTH_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == AUTH_REQUEST_CODE) {
                if (data != null) {
                    IdpResponse response = IdpResponse.fromResultIntent(data);
                    {
                        if (response != null) {
                            welcome();
                        }
                    }
                }
            }
        }
    }

    private void welcome() {
        Toast.makeText(SplashScreen.this, "Welcome Back", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(SplashScreen.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
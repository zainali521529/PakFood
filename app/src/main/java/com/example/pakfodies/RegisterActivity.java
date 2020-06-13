package com.example.pakfodies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.pakfodies.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding mBinding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mAuth=FirebaseAuth.getInstance();

        clickview();
    }

    private void clickview() {
        mBinding.registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname =mBinding.fullNameet.getText().toString().trim();
                String email =mBinding.emailEt.getText().toString().trim();
                String password =mBinding.passwordEt.getText().toString().trim();
                String repeatpassword =mBinding.repeatPasswordEt.getText().toString().trim();
                if (TextUtils.isEmpty(fullname)){
                    mBinding.fullNameet.setError("Full Name is Required");
                }
                if (TextUtils.isEmpty(email)){
                    mBinding.emailEt.setError("Email is Required");
                }
                if (TextUtils.isEmpty(password)){
                    mBinding.passwordEt.setError("Password is Required");
                }
                if (TextUtils.isEmpty(repeatpassword)){
                    mBinding.repeatPasswordEt.setError("Repeat Password is Required");
                }
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this,"Create ID Successfully",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(RegisterActivity.this,AuthActivity.class);
                            startActivity(intent);
                        }else Toast.makeText(RegisterActivity.this,"Error!"+task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }
                });


            }
        });

    }
}
package com.febry.kelaslnt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserAuthenticationActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin, btnSignup;

    //Kalo merah, pencet alt enter
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_authentication);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnSignup = findViewById(R.id.btn_signup);

        btnSignup.setOnClickListener(view -> {
            String email, password;

            email = etEmail.getText().toString();
            password = etPassword.getText().toString();

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(UserAuthenticationActivity.this,  task -> {
                        if(task.isSuccessful()){
                            //pindah activity, dan tetapkan user telah login
                            Toast.makeText(UserAuthenticationActivity.this, "SignUp Berhasil", Toast.LENGTH_SHORT).show();


                            //Tarik identitas user
                            user = mAuth.getCurrentUser();

                            Toast.makeText(UserAuthenticationActivity.this, "Hello " + user.getEmail() + " your UID is " + user.getUid(), Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(UserAuthenticationActivity.this, CreateProfileActivity.class);
                            startActivity(intent);
                            finish();

                        } else {
                            //Output kesalahannya
                            Toast.makeText(UserAuthenticationActivity.this, "SignUp Gagal " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        });




        btnLogin.setOnClickListener(view -> {

            String email, password;

            email = etEmail.getText().toString();
            password = etPassword.getText().toString();


            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(UserAuthenticationActivity.this, task -> {

                        if(task.isSuccessful()){
                            Toast.makeText(UserAuthenticationActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(UserAuthenticationActivity.this, CreateProfileActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(UserAuthenticationActivity.this, "Login Failed " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    });
        });


    }
}
package com.febry.kelaslnt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.febry.kelaslnt.data.Test;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateProfileActivity extends AppCompatActivity {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user;
    private DatabaseReference mDatabase;

    private EditText etName;
    private Button btnOk;


    @Override
    protected void onStart() {
        super.onStart();
        user = mAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);


        etName = findViewById(R.id.et_name);
        btnOk = findViewById(R.id.btn_ok);

        btnOk.setOnClickListener(view -> {
            String name;

            name = etName.getText().toString();

            UserProfileChangeRequest newProfile = new UserProfileChangeRequest.Builder()
                    .setDisplayName(name)
                    .build();

            user.updateProfile(newProfile)
                    .addOnCompleteListener(CreateProfileActivity.this, task -> {
                       if(task.isSuccessful()){
                           Toast.makeText(CreateProfileActivity.this, "Update profile success, hello " + user.getDisplayName(), Toast.LENGTH_SHORT).show();
                       }
                    });
        });

        Test test = new Test("TESTING SATU", "TESTING DUA");

        mDatabase.child("Test").setValue(test);
    }
}
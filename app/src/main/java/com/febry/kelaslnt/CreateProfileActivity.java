package com.febry.kelaslnt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.febry.kelaslnt.data.Test;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateProfileActivity extends AppCompatActivity {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user;

    private DatabaseReference mDatabase;

    private EditText etName;
    private Button btnOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        user = mAuth.getCurrentUser();


        mDatabase = FirebaseDatabase.getInstance().getReference("Test");


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


        Test test = new Test("Hello", "World", 123);

        //Auto generate id
        String id = mDatabase.push().getKey();

        mDatabase.child(id).setValue(test);

        user = mAuth.getCurrentUser();


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot singleSnap : snapshot.getChildren()){
                    Test dataMasuk =  singleSnap.getValue(Test.class);
                    Toast.makeText(CreateProfileActivity.this, singleSnap.getKey(), Toast.LENGTH_SHORT).show();



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(CreateProfileActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        mDatabase.child("-N-7raIHXB7Nx66dSRik").removeValue();
    }
}


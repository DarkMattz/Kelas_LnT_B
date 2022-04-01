package com.febry.kelaslnt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class ActivityTambahan extends AppCompatActivity {

    private Button btnBack;
    private int pencetBack = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahan);

        getSupportFragmentManager().beginTransaction() //bagian inisialisasi awal
                .setReorderingAllowed(true)
                .add(R.id.fragmentContainerView, TestFragmentSatu.class, null)
                .commit();

        btnBack = findViewById(R.id.btn_back);

        btnBack.setOnClickListener(view -> {

            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainerView, TestFragmentDua.class, null)
                    .commit();

//            //Progress Dialog
//            ProgressDialog progressDialog = new ProgressDialog(this);
//
//            progressDialog.setMessage("Loading");
//
//            progressDialog.setTitle("Loading Sesuatu");
//
//            progressDialog.setCancelable(false);
//
//            progressDialog.show();
//
//            onBackPressed();
//
//            progressDialog.dismiss();
//            //Jangan pake ini kalo mau balik
////            Intent intent = new Intent(this, MainActivity.class);
////            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
//        Toast.makeText(this, "Kembali", Toast.LENGTH_SHORT).show();

        if(pencetBack < 1){
            Toast.makeText(this, "Pencet sekali lagi", Toast.LENGTH_SHORT).show();
            pencetBack++;
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_satu){
            Toast.makeText(this, "Menu satu diclick", Toast.LENGTH_SHORT).show();
            return true;
        } else if(item.getItemId() == R.id.menu_dua){
            Toast.makeText(this, "Menu dua diclick", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return false;
        }
    }
}
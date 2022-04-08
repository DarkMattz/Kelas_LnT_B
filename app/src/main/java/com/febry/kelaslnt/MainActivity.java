package com.febry.kelaslnt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.febry.kelaslnt.data.IsiRecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button buttonActivity, buttonChangeText;
    private TextView textView;
    private EditText editText;
    private RecyclerView recyclerView;

    private ImageView imageView;

    //OnCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Create"); //Khusus debugging aja
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Glide.with(this)
                .load(R.drawable.ic_launcher_foreground)
                .into(imageView);




//        IsiRecyclerView[] isiRecyclerView = new IsiRecyclerView[6];
//        isiRecyclerView[0] = new IsiRecyclerView("Data pertama", "Halooo");
//        isiRecyclerView[1] = new IsiRecyclerView("Data Kedua", "Halo  halo");
//        isiRecyclerView[2] = new IsiRecyclerView("Data Ketiga", "sjladfhlksdhf");
//        isiRecyclerView[3] = new IsiRecyclerView("Keempat DAta", "sdklojfhsdjklhf");
//        isiRecyclerView[4] = new IsiRecyclerView("ojsdhjklash", "skjdfhsdjklfh");
//        isiRecyclerView[5] = new IsiRecyclerView("Helooo", "sdkjfhsdjklhf");
//
//
//
//
//        recyclerView = findViewById(R.id.rv_widget);
//        recyclerView.setAdapter(new RecyclerViewAdapter(isiRecyclerView, this));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//
//
//        buttonActivity = findViewById(R.id.btn_switch_activity);
//        buttonChangeText = findViewById(R.id.buttonchangetext);
//        editText = findViewById(R.id.editTextTextPersonName);
//        textView = findViewById(R.id.textView);
//
//        buttonActivity.setOnClickListener(view -> {
//            Intent intent = new Intent(this, ActivityTambahan.class); //create instance activity
//
//            startActivity(intent); //pindah ke activitinya
//        });
//
//        buttonChangeText.setOnClickListener(view -> {
//            textView.setText(editText.getText().toString());
//        });
    }



    @Override
    protected void onStart() {
        System.out.println("Start");
        super.onStart();
    }

    @Override
    protected void onResume() {
        System.out.println("Resume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        System.out.println("Pause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println("Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.println("Destroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        System.out.println("Restart");
        super.onRestart();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("textview", textView.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String text = savedInstanceState.getString("textview");
        textView.setText(text);
    }
}

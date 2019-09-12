package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Challenges extends AppCompatActivity {



    @Override
    public void onBackPressed() {
        startActivity(new Intent(Challenges.this,Dashboard.class));super.onBackPressed();
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);
    }
}

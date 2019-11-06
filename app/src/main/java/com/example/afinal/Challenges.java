package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class Challenges extends AppCompatActivity {


    Typeface dys;
    TextView c1;
    TextView c2;
    TextView c3;
    TextView c4;
    TextView c5;
    TextView c6;
    TextView c7;
    TextView c8;
    TextView c9;
    TextView c10;
    TextView c11;
    TextView c12;




    @Override
    public void onBackPressed() {
        startActivity(new Intent(Challenges.this,Dashboard.class));super.onBackPressed();
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);
        global abc = (global) getApplicationContext();
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);
        c9 = findViewById(R.id.c9);
        c10 = findViewById(R.id.c10);
        c11 = findViewById(R.id.c11);
        c12 = findViewById(R.id.c12);
        if(abc.getDyslexic()==0||abc.getDyslexic()==2||abc.getDyslexic()==4||abc.getDyslexic()==6||abc.getDyslexic()==8||abc.getDyslexic()==10||abc.getDyslexic()==12||abc.getDyslexic()==14||abc.getDyslexic()==16||abc.getDyslexic()==18||abc.getDyslexic()==20||abc.getDyslexic()==22||abc.getDyslexic()==24||abc.getDyslexic()==26||abc.getDyslexic()==28||abc.getDyslexic()==30||abc.getDyslexic()==32||abc.getDyslexic()==34) {

            dys = Typeface.createFromAsset(getAssets(), "fonts/sans.ttf");
            c1.setTypeface(dys);
            c2.setTypeface(dys);
            c3.setTypeface(dys);
            c4.setTypeface(dys);
            c5.setTypeface(dys);
            c6.setTypeface(dys);
            c7.setTypeface(dys);
            c8.setTypeface(dys);
            c9.setTypeface(dys);
            c10.setTypeface(dys);
            c11.setTypeface(dys);
            c12.setTypeface(dys);

        }else{
            dys = Typeface.createFromAsset(getAssets(), "fonts/dyslexic.ttf");

            c1.setTypeface(dys);
            c2.setTypeface(dys);
            c3.setTypeface(dys);
            c4.setTypeface(dys);
            c5.setTypeface(dys);
            c6.setTypeface(dys);
            c7.setTypeface(dys);
            c8.setTypeface(dys);
            c9.setTypeface(dys);
            c10.setTypeface(dys);
            c11.setTypeface(dys);
            c12.setTypeface(dys);

        }
    }
}

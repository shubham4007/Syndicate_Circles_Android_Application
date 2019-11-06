package com.example.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;
import java.util.List;

public class Dashboard extends AppCompatActivity {
    DatabaseReference ref1;
    FirebaseDatabase fire;
    int count=0;
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
    String abc;


    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);


    }

    Intent goOther;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        final CardView Enquiry;
        CardView product;
        CardView challenges;
        CardView profile;
        CardView leaderboards;
        CardView leadsinfo;
        TextView text;

        ref1 = FirebaseDatabase.getInstance().getReference();

        ref1.child("Agent").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();



                while (items.hasNext()){

                    DataSnapshot item = items.next();

                    count = count +1;

                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });








        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(Dashboard.this,Lead.class));
                overridePendingTransition(R.anim.goup, R.anim.godown);
            }
        });

        profile = (CardView) findViewById(R.id.pr);
        product = (CardView) findViewById(R.id.pc);
        challenges = (CardView) findViewById(R.id.chal);
        Enquiry = (CardView) findViewById(R.id.enq);
        leaderboards = (CardView) findViewById(R.id.lb);
        leadsinfo = (CardView)findViewById(R.id.ld);


        leadsinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Dashboard.this,Lead_information.class);
                startActivity(in);
            }
        });


        leaderboards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Dashboard.this,Leaderboards.class);
                in.putExtra("keyName",abc);
                startActivity(in);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Dashboard.this, profile.class);
                startActivity(in);

            }
        });
        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, Product_catalouge.class));

            }
        });
        challenges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, Challenges.class));

            }
        });
        Enquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, Enquiry.class));

            }
        });

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
        global abcd =(global) getApplicationContext();
        if(abcd.getDeep_link()==1){startActivity(new Intent(Dashboard.this,Lead.class));finish();}
    }
}

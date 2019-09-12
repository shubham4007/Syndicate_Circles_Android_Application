package com.example.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class Dashboard extends AppCompatActivity {
    DatabaseReference ref1;
    FirebaseDatabase fire;
    int count=0;

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


    }
}

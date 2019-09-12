package com.example.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class profile extends AppCompatActivity {

    FirebaseAuth mAuth;
    String data;
    TextView name;
    TextView email;
    TextView region;

    String Name;
    String Email;
    String Region;
    TextView lead;
    TextView leadConv;
    TextView point;
    TextView rank;

    String Lead;
    String conv;
    String points;
    String userid;

    ImageView verified;
    FirebaseDatabase database;
    DatabaseReference ref;




    @Override
    public void onBackPressed() {
        startActivity(new Intent(profile.this,Dashboard.class));super.onBackPressed();
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();

        name = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        region = (TextView) findViewById(R.id.region);
        lead = (TextView) findViewById(R.id.lead);
        leadConv = (TextView) findViewById(R.id.leadc);
        point = (TextView) findViewById(R.id.points);
        verified = (ImageView) findViewById(R.id.verified);
        rank = (TextView) findViewById(R.id.Rank);

        global abf = (global)getApplicationContext();
        Name = abf.getName();
        Email = abf.getEmail();
        Region = abf.getRegion();
        Lead = abf.getLead();
        conv = abf.getLeadConverted();
        points = abf.getPoints();

        name.setText(Name);
        email.setText(Email);
        region.setText(Region);
        lead.setText(Lead);
        leadConv.setText(conv);
        point.setText(points);

        int ab = Integer.parseInt(conv);

        if(ab>100){

            verified.setVisibility(View.VISIBLE);

        }
        if(ab>=100 & ab<=200){
            rank.setText("Level 2");
        }else if(ab>=201 & ab<=300){
            rank.setText("Level 3");
        }else if(ab>=301 & ab<=350){
            rank.setText("Level 4");
        }else if(ab>=100 & ab<=200){
            rank.setText("Level 5");
        }else {
            rank.setText("Beginner");
        }



        Button signout = (Button) findViewById(R.id.Signout);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(profile.this,MainActivity.class));
                finish();
            }
        });

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Agents");

        try {
            userid = Email;
            userid = userid.replace(".", "%");
        }catch(NullPointerException ignored){}
        ref.child(userid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    leadConv.setText(dataSnapshot.child("leadConverted").getValue().toString());
                }catch (NullPointerException ignored){}


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref.child(userid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    lead.setText(dataSnapshot.child("lead").getValue().toString());
                }catch (NullPointerException ignored){}

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref.child(userid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    point.setText(dataSnapshot.child("points").getValue().toString());
                }catch (NullPointerException ignored){}

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}

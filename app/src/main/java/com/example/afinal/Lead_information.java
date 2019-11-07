package com.example.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class Lead_information extends AppCompatActivity {

    private RecyclerView mBloglist;
    private DatabaseReference mDatabase;

    TextView name;
    TextView productrefered;
    TextView age;
    TextView leademail;
    Button status;

    TextView name2;
    TextView productrefered2;
    TextView age2;
    TextView leademail2;
    TextView status2;

    TextView name3;
    TextView productrefered3;
    TextView age3;
    TextView leademail3;
    TextView status3;

    Leads lead;
    String name1 = "0";
    String userid;
    CardView card1,card2,card3;

    DatabaseReference ref;
    DatabaseReference ref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_information);

        name = findViewById( R.id.c1);
        productrefered =findViewById(R.id.c2);
        age = findViewById(R.id.c3);
        leademail = findViewById(R.id.c4);
        status = findViewById(R.id.status1);

        name2 = findViewById( R.id.c5);
        productrefered2 =findViewById(R.id.c6);
        age2 = findViewById(R.id.c7);
        leademail2 = findViewById(R.id.c8);
        status2 = findViewById(R.id.status2);

        name3 = findViewById( R.id.c9);
        productrefered3 =findViewById(R.id.c10);
        age3 = findViewById(R.id.c11);
        leademail3 = findViewById(R.id.c12);
        status3 = findViewById(R.id.status3);


        card1 = findViewById(R.id.card1);

        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);




        global abc = (global) getApplicationContext();

        if(abc.getLeadcount()!=0 && abc.getLeadcount()!=1 && abc.getLeadcount()!=2){
            Toast.makeText(getApplicationContext(), "No Lead generated ", Toast.LENGTH_SHORT).show();
        }

        if(abc.getLeadcount()==0){

            card1.setVisibility(View.VISIBLE);
            name.setText("Name: "+abc.getLeadname());
            productrefered.setText("Product: "+abc.getLeadproduct());
            age.setText("Age: "+abc.getLeadage());
            leademail.setText("Email: "+abc.getLeademail());
           // Toast.makeText(Lead_information.this, abc.getLeademail()+abc.getLeadage()+abc.getLeadname()+abc.getLeadproduct(), Toast.LENGTH_SHORT).show();

        }else if(abc.getLeadcount()==1){

            card2.setVisibility(View.VISIBLE);

            card1.setVisibility(View.VISIBLE);
            name.setText("Name: "+abc.getLeadname());
            productrefered.setText("Product: "+abc.getLeadproduct());
            age.setText("Age: "+abc.getLeadage());
            leademail.setText("Email: "+abc.getLeademail());

            name2.setText("Name: "+abc.getLeadname2());
            productrefered2.setText("Product: "+abc.getLeadproduct2());
            age2.setText("Age: "+abc.getLeadage2());
            leademail2.setText("Email: "+abc.getLeademail2());

        }else if(abc.getLeadcount()==2) {

            card3.setVisibility(View.VISIBLE);

            card2.setVisibility(View.VISIBLE);

            card1.setVisibility(View.VISIBLE);
            name.setText("Name: "+abc.getLeadname());
            productrefered.setText("Product: "+abc.getLeadproduct());
            age.setText("Age: "+abc.getLeadage());
            leademail.setText("Email: "+abc.getLeademail());

            name2.setText("Name: "+abc.getLeadname2());
            productrefered2.setText("Product: "+abc.getLeadproduct2());
            age2.setText("Age: "+abc.getLeadage2());
            leademail2.setText("Email: "+abc.getLeademail2());

            name3.setText("Name: " + abc.getLeadname3());
            productrefered3.setText("Product: " + abc.getLeadproduct3());
            age3.setText("Age: " + abc.getLeadage3());
            leademail3.setText("Email: " + abc.getLeademail3());

        }

        ref =FirebaseDatabase.getInstance().getReference();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("sfsf","abcdef");
                global abc = (global) getApplicationContext();
                try {
                    Log.i("sfsf","abcdefg");
                    userid = abc.getLeademail();
                    try {
                        userid = userid.replace(".", "%");
                    }catch(NullPointerException ignored){}
                    name1=dataSnapshot.child("Convert").child("convert").getValue().toString();
                    Log.i("sfsf",name1);
                    if(abc.getLeadcount()==0){


                        if(name1.equals("1")){
                            status.setText("Status: Succesfully converted");

                        }
                    }else if(abc.getLeadcount()==1){

                            if(name1.equals("1")) {
                                status.setText("Status: Succesfully converted");
                            }
                    }else if(abc.getLeadcount()==2) {

                                if (name1.equals("1")) {
                                    status.setText("Status: Succesfully converted");
                                }
                            }


                }catch(NullPointerException ig){
                    Log.i("sfsf",ig.toString());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                   Log.i("sfsf",databaseError.toException().toString());
            }
        });

        ref1 = FirebaseDatabase.getInstance().getReference();

        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                global abc = (global) getApplicationContext();
                if(name1.equals("1")){
                    Log.i("sfsf","abcdefg");
                    userid = abc.getEmail();
                    try {
                        userid = userid.replace(".", "%");
                    }catch(NullPointerException ignored){}
                    ref.child("Agent").child(userid).child("leadConverted").setValue("1");
                    ref.child("Agent").child(userid).child("points").setValue(30);

                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });








    }


}

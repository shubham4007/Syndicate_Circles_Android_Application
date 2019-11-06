package com.example.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GmailRegisteration extends AppCompatActivity {

    FirebaseDatabase database;
    FirebaseAuth firebaseAuth;
    DatabaseReference ref;
    Agent agent;
    Button register;
    private String userid;

    Typeface dys;

    private EditText name;
    private  EditText Region;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmail_registeration);


        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Agent");

        name = (EditText) findViewById(R.id.Name);
        Region = (EditText) findViewById(R.id.Region);
        register = (Button) findViewById(R.id.register);

        global abc = (global) getApplicationContext();
        if(abc.getDyslexic()==0||abc.getDyslexic()==2||abc.getDyslexic()==4||abc.getDyslexic()==6||abc.getDyslexic()==8||abc.getDyslexic()==10||abc.getDyslexic()==12||abc.getDyslexic()==14||abc.getDyslexic()==16||abc.getDyslexic()==18||abc.getDyslexic()==20||abc.getDyslexic()==22||abc.getDyslexic()==24||abc.getDyslexic()==26||abc.getDyslexic()==28||abc.getDyslexic()==30||abc.getDyslexic()==32||abc.getDyslexic()==34) {

            dys = Typeface.createFromAsset(getAssets(), "fonts/sans.ttf");
            name.setTypeface(dys);
            Region.setTypeface(dys);
            register.setTypeface(dys);


        }else{


            dys = Typeface.createFromAsset(getAssets(), "fonts/dyslexic.ttf");
            name.setTypeface(dys);
            Region.setTypeface(dys);
            register.setTypeface(dys);
        }


        agent = new Agent();

        firebaseAuth = FirebaseAuth.getInstance();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( !validateName() | !validateRegion() ) {
                    return;
                }

                global Global = (global) getApplicationContext();


                Global.setName(name.getText().toString());
                Global.setRegion(Region.getText().toString());

                try {

                    userid = Global.getEmail();
                    userid = userid.replace(".","%");

                }catch(NullPointerException ignored){Log.i("abc",ignored.toString());}





                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        try {
                            getDetails();
                            ref.child(userid).setValue(agent);
                        }catch (NullPointerException ignored){Log.i("bnh","mkj");}

                        startActivity(new Intent(GmailRegisteration.this,Dashboard.class));
                        finish();


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }


                });

            }
        });


    }
    private boolean validateName() {
        String usernameInput = name.getText().toString().trim();

        if (usernameInput.isEmpty()) {
            name.setError("Field can't be empty");
            return false;
        } else {
            name.setError(null);
            return true;
        }
    }

    private boolean validateRegion() {
        String usernameInput = Region.getText().toString().trim();

        if (usernameInput.isEmpty()) {
            Region.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 15) {
            Region.setError("Username too long");
            return false;
        } else {
            Region.setError(null);
            return true;
        }
    }

    public void getDetails(){

        global Globe = (global) getApplicationContext();

        try {
            agent.setName(name.getText().toString());

        agent.setEmail(Globe.getEmail().toString());
        agent.setState(Region.getText().toString());
        agent.setPhone("1234567890");
        agent.setPoints(Globe.getPoints());
        agent.setLead(Globe.getLead());
        agent.setLeadConverted(Globe.getLeadConverted());}catch (NullPointerException ig){Log.i("abc","def");}

    }



}

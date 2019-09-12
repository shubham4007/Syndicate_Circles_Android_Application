package com.example.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lead extends AppCompatActivity {

    FirebaseDatabase database,database1;
    DatabaseReference ref,ref2;
    Leads lead;
    Agent agent;

    EditText Name;
    EditText Email;
    EditText Age;

    EditText ProductReffered;
    String userid;
    String Date;
    String x;
    String agentemail;
    int y;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Lead.this,Dashboard.class));
        //Add the OnBackPressed into Other activity when the BackPressed
        overridePendingTransition(R.anim.goup, R.anim.godown);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead);

       Name  = (EditText) findViewById(R.id.CustomerName);
       Email = (EditText) findViewById(R.id.email);
       Age   = (EditText) findViewById(R.id.age);

       ProductReffered = (EditText) findViewById(R.id.ProductRefered);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Leads");

        lead = new Leads();
        agent = new Agent();


    }

    private boolean validateEmail() {
        String emailInput = Email.getText().toString().trim();

        if (emailInput.isEmpty()) {
            Email.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            Email.setError("Please enter a valid email address");
            return false;
        } else {
            Email.setError(null);
            return true;
        }
    }



    private boolean validateName() {
        String usernameInput = Name.getText().toString().trim();

        if (usernameInput.isEmpty()) {
            Name.setError("Field can't be empty");
            return false;
        } else {
            Name.setError(null);
            return true;
        }
    }

    private boolean validateUserAge() {
        String usernameInput = Age.getText().toString().trim();

        if (usernameInput.isEmpty()) {
            Age.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 3) {
            Age.setError("Enter Correct age");
            return false;
        } else {
            Age.setError(null);
            return true;
        }
    }

    public void getDetails(){

        global gb = (global) getApplicationContext();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date date = new Date();
        Date = dateFormat.format(date);

        lead.setName(Name.getText().toString());
        lead.setEmail(Email.getText().toString());
        lead.setAge(Age.getText().toString());
        lead.setRefer(gb.getName());
        lead.setProduct(ProductReffered.getText().toString());
        lead.setDate(Date);


    }

    public void AddLead(View view){

        if (!validateEmail() | !validateName() | !validateUserAge()) {
            return;
        }

        userid = Email.getText().toString();
        userid = userid.replace(".","%");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getDetails();

                ref.child(userid).setValue(lead);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        global globe = (global) getApplicationContext();
        x = globe.getLead();
        y = Integer.parseInt(x);
        y=y+1;

        globe.setLead(Integer.toString(y));
        Log.i("lead",Integer.toString(y));
        Log.i("lead",globe.getLead());

        agentemail = globe.getEmail();
        agentemail = agentemail.replace(".","%");


        DatabaseReference updateData = FirebaseDatabase.getInstance()
                .getReference("Agent")
                .child(agentemail);

        Log.i("lead",globe.getLead());

        updateData.child("lead").setValue(globe.getLead());

        startActivity(new Intent(Lead.this,Dashboard.class));
        //Add the OnBackPressed into Other activity when the BackPressed
        overridePendingTransition(R.anim.godown, R.anim.godown);






    }

    public void updateDetails(){

        global global = (global) getApplicationContext();

        agent.setName(global.getName());
        agent.setEmail(global.getEmail());
        agent.setState(global.getRegion());
        agent.setPassword(global.getPassword());
        agent.setPhone("1234567890");
        agent.setLeadConverted(global.getLeadConverted());
        agent.setLead(Integer.toString(y));
        agent.setPoints(global.getPoints());

    }
}

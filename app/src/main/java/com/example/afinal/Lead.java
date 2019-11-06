package com.example.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Region;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Lead extends AppCompatActivity {

    FirebaseDatabase database,database1;
    DatabaseReference ref,ref2;
    Leads lead;
    Agent agent;
    int count ;

    Typeface dys;
    TextView c1;
    Button submit;

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
       c1 = findViewById(R.id.c1);
       submit = findViewById(R.id.button);

       ProductReffered = (EditText) findViewById(R.id.ProductRefered);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Leads");

        lead = new Leads();
        agent = new Agent();

        global abc = (global) getApplicationContext();
        if(abc.getDyslexic()==0||abc.getDyslexic()==2||abc.getDyslexic()==4||abc.getDyslexic()==6||abc.getDyslexic()==8||abc.getDyslexic()==10||abc.getDyslexic()==12||abc.getDyslexic()==14||abc.getDyslexic()==16||abc.getDyslexic()==18||abc.getDyslexic()==20||abc.getDyslexic()==22||abc.getDyslexic()==24||abc.getDyslexic()==26||abc.getDyslexic()==28||abc.getDyslexic()==30||abc.getDyslexic()==32||abc.getDyslexic()==34) {

            dys = Typeface.createFromAsset(getAssets(), "fonts/sans.ttf");
            Name.setTypeface(dys);
            Email.setTypeface(dys);
            Age.setTypeface(dys);
            c1.setTypeface(dys);
            submit = findViewById(R.id.button);



        }else{


            dys = Typeface.createFromAsset(getAssets(), "fonts/dyslexic.ttf");
            Name.setTypeface(dys);
            Email.setTypeface(dys);
            Age.setTypeface(dys);
            c1.setTypeface(dys);
            submit = findViewById(R.id.button);

        }


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
        lead.setCheck(gb.getLeadConverted());




    }

    public void AddLead(View view){

        if (!validateEmail() | !validateName() | !validateUserAge()) {
            return;
        }


        global g = (global) getApplicationContext();

        count = g.getLeadcount()+1;
        g.setLeadcount(count);

        if(count==0){

            g.setLeadname(Name.getText().toString());
            g.setLeadage(Age.getText().toString());
            g.setLeademail(Email.getText().toString());
            g.setLeadproduct(ProductReffered.getText().toString());

        }else if(count==1){

            g.setLeadname2(Name.getText().toString());
            g.setLeadage2(Age.getText().toString());
            g.setLeademail2(Email.getText().toString());
            g.setLeadproduct2(ProductReffered.getText().toString());

        }else if(count ==2){

            g.setLeadname3(Name.getText().toString());
            g.setLeadage3(Age.getText().toString());
            g.setLeademail3(Email.getText().toString());
            g.setLeadproduct3(ProductReffered.getText().toString());

        }




        global globe = (global) getApplicationContext();



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

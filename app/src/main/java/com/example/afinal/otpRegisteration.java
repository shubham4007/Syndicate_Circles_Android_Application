package com.example.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class otpRegisteration extends AppCompatActivity {

    FirebaseDatabase database;
    FirebaseAuth firebaseAuth;
    DatabaseReference ref;
    Agent agent;
    private String userid;

    EditText textInputname;
    EditText textInputEmail;
    EditText Region;

    public void onBackPressed() {

        firebaseAuth.signOut();
        startActivity(new Intent(otpRegisteration.this,MainActivity.class));
        finish();
        Toast.makeText(this, "Regiseration Failed", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_registeration);

        textInputname =(EditText) findViewById(R.id.editText1);
        textInputEmail =(EditText) findViewById(R.id.editText4);
        Region =(EditText) findViewById(R.id.editText3);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Agent");

        agent = new Agent();

        firebaseAuth = FirebaseAuth.getInstance();
    }
    private boolean validateEmail() {
        String emailInput = textInputEmail.getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputEmail.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            textInputEmail.setError("Please enter a valid email address");
            return false;
        } else {
            textInputEmail.setError(null);
            return true;
        }
    }
    private boolean validateName() {
        String usernameInput = textInputname.getText().toString().trim();

        if (usernameInput.isEmpty()) {
            textInputname.setError("Field can't be empty");
            return false;
        } else {
            textInputname.setError(null);
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

        agent.setName(textInputname.getText().toString());
        agent.setEmail(textInputEmail.getText().toString());
        agent.setState(Region.getText().toString());
        agent.setPhone(Globe.getNumber());
        agent.setPoints(Globe.getPoints());
        agent.setLead(Globe.getLead());
        agent.setLeadConverted(Globe.getLeadConverted());

    }



    public void confirmInput(View v) {
        if (!validateEmail()  | !validateName() | !validateRegion() ) {
            return;
        }

        global Global = (global) getApplicationContext();


        Global.setName(textInputname.getText().toString());
        Global.setEmail(textInputEmail.getText().toString());
        Global.setRegion(Region.getText().toString());

        userid = textInputEmail.getText().toString();
        userid = userid.replace(".","%");



        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getDetails();
                ref.child(userid).setValue(agent);
                startActivity(new Intent(otpRegisteration.this,Dashboard.class));


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });






    }
}

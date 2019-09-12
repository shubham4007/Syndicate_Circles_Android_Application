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

import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {


    FirebaseDatabase database;
    FirebaseAuth firebaseAuth;
    DatabaseReference ref;
    Agent agent;
    private String userid;

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    EditText textInputname;
    EditText textInputEmail;
    EditText password;

    EditText Region;


    @Override
    public void onBackPressed() {
        firebaseAuth.signOut();
        startActivity(new Intent(Registration.this,MainActivity.class));
        finish();
        Toast.makeText(this, "Regiseration Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        textInputname =(EditText) findViewById(R.id.editText1);
        textInputEmail =(EditText) findViewById(R.id.editText2);
        password=(EditText) findViewById(R.id.editText3);
        Region =(EditText) findViewById(R.id.editText4);
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

    private boolean validatePassword() {
        String passwordInput = password.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            password.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            password.setError("Password too weak");
            return false;
        } else {
            password.setError(null);
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

        global global = (global) getApplicationContext();

        agent.setName(textInputname.getText().toString());
        agent.setEmail(textInputEmail.getText().toString());
        agent.setState(Region.getText().toString());
        agent.setPassword(password.getText().toString());
        agent.setPhone("1234567890");
        agent.setLeadConverted(global.getLeadConverted());
        agent.setLead(global.getLead());
        agent.setPoints(global.getPoints());

    }



    public void confirmInput(View v) {
        if (!validateEmail()  | !validateName() | !validateRegion() | !validatePassword()) {
            return;
        }

        global Global = (global) getApplicationContext();


        Global.setName(textInputname.getText().toString());
        Global.setEmail(textInputEmail.getText().toString());
        Global.setPassword(password.getText().toString());
        Global.setRegion(Region.getText().toString());

        userid = textInputEmail.getText().toString();
        userid = userid.replace(".","%");



        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getDetails();
                ref.child(userid).setValue(agent);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        String text = textInputEmail.getText().toString().trim();
        String pass = password.getText().toString().trim();

        (firebaseAuth.createUserWithEmailAndPassword(text,pass)).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Toast.makeText(Registration.this, "Registeration Succesfull", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Registration.this,Dashboard.class));

                }
            }
        });


    }



}

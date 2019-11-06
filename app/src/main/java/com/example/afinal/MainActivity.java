package com.example.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;

import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText Email;
    EditText Password;
    DatabaseReference reference;
    private String userid;
    TextView Register;
    TextView textView;
    TextView textView2;
    ImageView gmail;
    String name;
    String email;
    String phone;
    String Gmailshow;
    String Gmailshow2;
    int count2 = 0;
    Typeface dys;
    int count3 = 0;

    Button signin1;
    Button signin;
    TextView textView3;
    TextView textView4;
    TextView circles;

    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 0 ;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private GoogleApiClient mGoogleApiClient;
    ProgressDialog progressDialog;
    DatabaseReference mDatabase;

    private CallbackManager mCallbackManager;
    private ImageView facebook;
    String email1;
    String count;
    int gmailcount = 0;
    private Boolean authFlag = false;
    ImageView logoo;
    ConstraintLayout linear;
    ConstraintLayout constraint;

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

    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);


    }




    @Override


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        Email = (EditText)findViewById(R.id.email);
        Password = (EditText)findViewById(R.id.password);
        Register = (TextView) findViewById(R.id.register);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        circles = (TextView) findViewById(R.id.circle);
        signin1 = (Button) findViewById(R.id.signin1);
        signin = (Button) findViewById(R.id.signin);
        final global abc  = (global) getApplicationContext();

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(abc.getDyslexic()==0||abc.getDyslexic()==2||abc.getDyslexic()==4||abc.getDyslexic()==6||abc.getDyslexic()==8||abc.getDyslexic()==10||abc.getDyslexic()==12||abc.getDyslexic()==14||abc.getDyslexic()==16||abc.getDyslexic()==18||abc.getDyslexic()==20||abc.getDyslexic()==22||abc.getDyslexic()==24||abc.getDyslexic()==26||abc.getDyslexic()==28||abc.getDyslexic()==30||abc.getDyslexic()==32||abc.getDyslexic()==34) {

                    dys = Typeface.createFromAsset(getAssets(), "fonts/dyslexic.ttf");
                    textView.setTypeface(dys);
                    textView2.setTypeface(dys);
                    textView3.setTypeface(dys);
                    textView4.setTypeface(dys);
                    circles.setTypeface(dys);
                    signin1.setTypeface(dys);
                    signin.setTypeface(dys);
                    Register.setTypeface(dys);
                    textView2.setText("Normal Interface");
                    count3++;
                }else{

                    dys = Typeface.createFromAsset(getAssets(), "fonts/sans.ttf");
                    textView.setTypeface(dys);
                    textView2.setTypeface(dys);
                    textView3.setTypeface(dys);
                    textView4.setTypeface(dys);
                    circles.setTypeface(dys);
                    signin1.setTypeface(dys);
                    signin.setTypeface(dys);
                    Register.setTypeface(dys);
                    textView2.setText("Interface for Dyslexic Users");
                    count3++;
                }

                abc.setDyslexic(count3);

            }
        });



                Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Registration.class));
            }
        });
                signin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        signin();
                    }
                });

        TextView OTP = (TextView) findViewById(R.id.otp);
        OTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,authentication.class));
            }
        });

        gmail = (ImageView) findViewById(R.id.gmail);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this , new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

                    }
                } /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        Intent intent = getIntent();
        String name  = intent.getStringExtra("value");






        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        final global abcd = (global) getApplicationContext();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull final FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {


                    final FirebaseUser user = firebaseAuth.getCurrentUser();





                        // Toast.makeText(MainActivity.this, "Now you are logged In " , Toast.LENGTH_SHORT).show();


                        if (isNumeric(user.getPhoneNumber())) {
                            try{
                                progressDialog = ProgressDialog.show(MainActivity.this, "Loading...", "Syncing your data Please wait.....");

                            }catch (WindowManager.BadTokenException e){}


                            mDatabase.child("Agent").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                    Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();


                                    if(abcd.getAuth()==1) {

                                        while (items.hasNext()) {

                                            count2 = count2 + 1;

                                            DataSnapshot item = items.next();
                                            try {
                                                email = item.child("email").getValue().toString();

                                            } catch (NullPointerException ignored) {
                                            }
                                            phone = item.child("phone").getValue().toString();
                                            Log.i("auth",phone);
                                            if (user.getPhoneNumber().equals(phone)) {
                                                abcd.setEmail(email);
                                                Log.i("auth","entered if");

                                                Log.i("auth",Integer.toString(abcd.getAuth()));
                                                abcd.setAuth(0);
                                                Log.i("auth",Integer.toString(abcd.getAuth()));

                                                Log.i("main", abcd.getEmail());
                                                try {
                                                    abcd.setName(item.child("name").getValue().toString());
                                                    abcd.setPoints(item.child("points").getValue().toString());
                                                    abcd.setLeadConverted(item.child("leadConverted").getValue().toString());
                                                    abcd.setLead(item.child("lead").getValue().toString());
                                                    abcd.setRegion(item.child("state").getValue().toString());
                                                } catch (NullPointerException ignored) {
                                                }
                                                Log.i("auth","Exit if");
                                                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                                                try {

                                                    progressDialog.dismiss();

                                                } catch (NullPointerException ignored) {
                                                }

                                                startActivity(intent);
                                                finish();
                                            }


                                        }


                                    }
                                    Log.i("auth",Integer.toString(abcd.getAuth()));

                                    if (abcd.getAuth() == 1) {

                                        Intent intent = new Intent(MainActivity.this, otpRegisteration.class);
                                        try {

                                            progressDialog.dismiss();

                                        } catch (NullPointerException ignored) {
                                        }

                                        startActivity(intent);
                                        finish();

                                    }




                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });


                        } else {


                            try{
                                progressDialog = ProgressDialog.show(MainActivity.this, "Loading...", "Syncing your data Please wait.....");

                            }catch (WindowManager.BadTokenException e){}

                            mDatabase.child("Agent").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                    Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();

                                    if(abcd.getAuth()==1) {

                                        while (items.hasNext()) {

                                            DataSnapshot item = items.next();

                                            try {

                                                email = item.child("email").getValue().toString();
                                            } catch (NullPointerException ignored) {


                                            }

                                            if (email.equals(firebaseAuth.getCurrentUser().getEmail())) {
                                                abcd.setEmail(email);
                                                abcd.setAuth(0);
                                                try {

                                                    abcd.setName(item.child("name").getValue().toString());
                                                    abcd.setPoints(item.child("points").getValue().toString());
                                                    abcd.setLeadConverted(item.child("leadConverted").getValue().toString());
                                                    abcd.setLead(item.child("lead").getValue().toString());
                                                    abcd.setRegion(item.child("state").getValue().toString());


                                                } catch (NullPointerException ignored) {


                                                }


                                                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                                                try {

                                                    progressDialog.dismiss();

                                                } catch (NullPointerException ignored) {
                                                }

                                                startActivity(intent);
                                                finish();
                                            }


                                        }
                                        if(abcd.getAuth()==1){startActivity(new Intent(MainActivity.this,GmailRegisteration.class));}
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });



                        }



                }

            }
        };

        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    signIn();
            }
        });

        mCallbackManager = CallbackManager.Factory.create();

        facebook = (ImageView) findViewById(R.id.facebook);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallbackManager = CallbackManager.Factory.create();
                LoginManager.getInstance().logInWithReadPermissions(MainActivity.this, Arrays.asList("email", "public_profile"));
                LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.d(TAG, "facebook:onSuccess:" + loginResult);
                        handleFacebookAccessToken(loginResult.getAccessToken());            }

                    @Override
                    public void onCancel() {
                        Log.d(TAG, "facebook:onCancel");

                         }

                        @Override
                        public void onError(FacebookException error) {
                            Log.d(TAG, "facebook:onError", error);


                        }
                        });    }
                });






    }

    public static boolean isNumeric(String str)
    {
        if(isNullOrEmpty(str)){

            return  false;}
        for (char c : str.toCharArray())
        {

            if (Character.isAlphabetic(c)){

                return false;}
        }
        return true;
    }

    public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);
        Log.i("msg","before progress bar");
        try{

            progressDialog = ProgressDialog.show(this, "Loading...", "Syncing your data Please wait.....");

        }catch (NullPointerException ignored){}

        Log.i("msg","after progress bar");
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override                public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information,br/>                        Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            final global global = (global) getApplicationContext();
                            global.setEmail(user.getEmail());

                            try{

                                progressDialog.dismiss();

                            }catch (NullPointerException ignored){}
                            mAuth.addAuthStateListener(mAuthListener);

                            Gmailshow = global.getEmail();
                            mDatabase = FirebaseDatabase.getInstance().getReference();
                            Log.i("msg","bfore dismiss");


                            Log.i("msg","after dismiss");
                            mDatabase.child("Agent").addValueEventListener(new ValueEventListener() {

                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {





                                    Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();


                                    while (items.hasNext()){

                                        DataSnapshot item = items.next();

                                        Log.i("msg","entered while");





                                        if(!isNullOrEmpty(mAuth.getCurrentUser().getEmail())) {



                                            email  = item.child("email").getValue().toString();

                                            Log.i("msg",email);

                                            if ((mAuth.getCurrentUser().getEmail()).equals(email)) {

                                                Log.i("msg","entered if");


                                                Gmailshow2 = email;
                                                gmailcount = gmailcount +1;
                                                if(gmailcount==2){

                                                    Log.i("msg",Integer.toString(gmailcount));
                                                    startActivity(new Intent(MainActivity.this, Dashboard.class));}
                                                count = email1;

                                                Log.i("msg",email);

                                                Log.i("msg","exit if");


                                            }





                                        }
                                    }

                                    Log.i("msg","exit on change");
                                    if(gmailcount==0){

                                        startActivity(new Intent(MainActivity.this, GmailRegisteration.class));}




                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });





                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed. Please Use another Account.",                                Toast.LENGTH_SHORT).show();

                        }


                    }
                    });}

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
                Log.i("msg","if 1");




            } else {
                // Google Sign In failed, update UI appropriately
                // ...
            }
        }

        if (requestCode == RC_SIGN_IN) {

            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
                Log.i("msg","if 2");


            } else {
                // Google Sign In failed, update UI appropriately
                }
            }else{
                mCallbackManager.onActivityResult(requestCode, resultCode, data);
            }

    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private void showProgress() {
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        try{


            progressDialog = ProgressDialog.show(this, "Loading...", "Syncing your data Please wait.....");
        }catch (NullPointerException ignored){}

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);

        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());


                        if(task.isSuccessful()) {
                            final global global = (global) getApplicationContext();
                            global.setEmail(mAuth.getCurrentUser().getEmail());
                            mDatabase = FirebaseDatabase.getInstance().getReference();
                            mDatabase.child("Agent").addValueEventListener(new ValueEventListener() {

                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {






                                    try{

                                        progressDialog.dismiss();


                                    }catch (NullPointerException ignored){}
                                    Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();

                                    if(global.getAuth()==1) {

                                        while (items.hasNext()) {

                                            DataSnapshot item = items.next();

                                            Log.i("msg", "entered while");


                                            if (!isNullOrEmpty(mAuth.getCurrentUser().getEmail())) {


                                                email = item.child("email").getValue().toString();

                                                Log.i("msg", email);

                                                if ((mAuth.getCurrentUser().getEmail()).equals(email)) {

                                                    Log.i("msg", "entered if");

                                                    Gmailshow2 = email;
                                                    gmailcount = gmailcount + 1;

                                                    global.setAuth(0);


                                                    Log.i("msg", Integer.toString(gmailcount));
                                                    startActivity(new Intent(MainActivity.this, Dashboard.class));

                                                    Log.i("msg", email);

                                                    Log.i("msg", "exit if");


                                                }


                                            }
                                        }
                                    }
                                    Log.i("msg","exit on change");
                                    if(global.getAuth()==1){startActivity(new Intent(MainActivity.this, GmailRegisteration.class));}
                                  }


                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });





                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
                        }else if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithCredential", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }else{

                            Toast.makeText(MainActivity.this, "Something Is Wrong", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }



        public  void signin(){



            if (!validateEmail()  |  !validatePassword()) {
                return;
            }

            String em = Email.getText().toString().trim();
            String ps = Password.getText().toString().trim();

        (mAuth.signInWithEmailAndPassword(em,ps)).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull final Task<AuthResult> task) {

                userid = Email.getText().toString();
                userid = userid.replace(".","%");



                reference = FirebaseDatabase.getInstance().getReference("Agent").child(userid);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        global Global = (global) getApplicationContext();

                        Global.setEmail(dataSnapshot.child("email").getValue().toString());
                        Global.setRegion(dataSnapshot.child("state").getValue().toString());
                        Global.setName(dataSnapshot.child("name").getValue().toString());
                        Global.setLead(dataSnapshot.child("lead").getValue().toString());
                        Global.setLeadConverted(dataSnapshot.child("leadConverted").getValue().toString());
                        Global.setPoints(dataSnapshot.child("points").getValue().toString());
                        if(task.isSuccessful()) {
                            startActivity(new Intent(MainActivity.this, Dashboard.class));
                        }else{

                            Toast.makeText(MainActivity.this, "WRONG PASSWORD", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                        Toast.makeText(MainActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });

    }

    private boolean validatePassword() {
        String passwordInput = Password.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            Password.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            Toast.makeText(MainActivity.this, "WRONG PASSWORD", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            Password.setError(null);
            return true;
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

}

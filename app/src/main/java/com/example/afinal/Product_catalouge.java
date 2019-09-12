package com.example.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class Product_catalouge extends AppCompatActivity {
    public void onBackPressed() {
        startActivity(new Intent(Product_catalouge.this,Dashboard.class));
        super.onBackPressed();
    }

    FirebaseDatabase database;
    DatabaseReference ref;
    Products products;

    TextView Agricultural_Loans;
    TextView CASA;
    TextView Corporate_Finance;
    TextView Education_Loans;
    TextView Priority_Sector_Loans;
    TextView FD;
    TextView Retail_Loans;
    TextView SME_Loans;

    private   CardView savings;
    private   CardView retail;
    private   CardView agri;
    private   CardView edu;
    private   CardView fixed;
    private   CardView sme;
    private   CardView prior;
    private   CardView finance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_catalouge);

         Agricultural_Loans= (TextView) findViewById(R.id.agriculturalloans);
         CASA= (TextView) findViewById(R.id.casa);
         Corporate_Finance= (TextView) findViewById(R.id.corporatefinance);
         Education_Loans= (TextView) findViewById(R.id.educationalloans);
         Priority_Sector_Loans= (TextView) findViewById(R.id.prioritysectorloans);
         FD= (TextView) findViewById(R.id.fd);
         Retail_Loans= (TextView) findViewById(R.id.retailloan);
         SME_Loans= (TextView) findViewById(R.id.smeloans);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Products");

        /*ref.child("Products").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Agricultural_Loans.setText(dataSnapshot.child("Agricultural_Loans").child("priority").getValue().toString());
                CASA.setText(dataSnapshot.child("CASA").child("priority").getValue().toString());
                Corporate_Finance.setText(dataSnapshot.child("Corporate_Finance").child("priority").getValue().toString());
                Education_Loans.setText(dataSnapshot.child("Educational_Loans").child("priority").getValue().toString());
                Priority_Sector_Loans.setText(dataSnapshot.child("Priority_Sector_Loans").child("priority").getValue().toString());
                FD.setText(dataSnapshot.child("FD").child("priority").getValue().toString());
                Retail_Loans.setText(dataSnapshot.child("Retail_Loans").child("priority").getValue().toString());
                SME_Loans.setText(dataSnapshot.child("SME_Loans").child("priority").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

        ref.child("CASA").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                CASA.setText( priorityfunction(dataSnapshot.child("priority").getValue().toString()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref.child("Agricultural_Loans").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Agricultural_Loans.setText( priorityfunction(dataSnapshot.child("priority").getValue().toString()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref.child("Corporate_Finance").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Corporate_Finance.setText( priorityfunction(dataSnapshot.child("priority").getValue().toString()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref.child("Education_Loans").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Education_Loans.setText(priorityfunction(dataSnapshot.child("priority").getValue().toString()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref.child("Priority_Sector_Loans").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Priority_Sector_Loans.setText( priorityfunction(dataSnapshot.child("priority").getValue().toString()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref.child("FD").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                FD.setText( priorityfunction(dataSnapshot.child("priority").getValue().toString()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref.child("Retail_Loans").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Retail_Loans.setText( priorityfunction(dataSnapshot.child("priority").getValue().toString()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref.child("SME_Loans").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                SME_Loans.setText( priorityfunction(dataSnapshot.child("priority").getValue().toString()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        savings = (CardView) findViewById(R.id.SavingsAcc);
        savings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.syndicatebank.in/products/deposits/savings-current"));
                startActivity(intent);
            }
        });

        retail = (CardView) findViewById(R.id.RentalLoans);
        retail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.syndicatebank.in/products/loan/retail-loans"));
                startActivity(intent);
            }
        });

        agri = (CardView) findViewById(R.id.AgriculturalLoans);
        agri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.syndicatebank.in/products/loan/agricultural-loans"));
                startActivity(intent);
            }
        });
        edu = (CardView) findViewById(R.id.EducationLoan);
        edu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.syndicatebank.in/products/loan/education-loans"));
                startActivity(intent);
            }
        });
        sme = (CardView) findViewById(R.id.sme);
        sme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.syndicatebank.in/products/loan/SyndMSMECare"));
                startActivity(intent);
            }
        });
        fixed = (CardView) findViewById(R.id.fixedDeposit);
        fixed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.syndicatebank.in/products/deposits/term-deposit"));
                startActivity(intent);
            }
        });
        finance = (CardView) findViewById(R.id.corporate);
        finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.syndicatebank.in/products/loan/corporate-finance"));
                startActivity(intent);
            }
        });
        prior = (CardView) findViewById(R.id.priority);
        prior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.syndicatebank.in/products/loan/other-priority-sector-loans"));
                startActivity(intent);
            }
        });

    }

    public String priorityfunction(String string){

        if(string.equals("1")){
            return "Low";
        }else if(string.equals("2")){
            return  "Medium";
        }else if(string.equals("3")){
            return "High";
        }else{
            return "Low";
        }

    }
}

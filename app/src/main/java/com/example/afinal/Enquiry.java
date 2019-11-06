package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Enquiry extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Enquiry.this,Dashboard.class));super.onBackPressed();
    }
    EditText subject;
    EditText query;
    Button send;
    TextView textView;
    Typeface dys;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);

        subject = (EditText) findViewById(R.id.editText);
        query = (EditText) findViewById(R.id.editText2);
        send = findViewById(R.id.Send);
        textView = findViewById(R.id.textView);

        global abc = (global) getApplicationContext();
        if(abc.getDyslexic()==0||abc.getDyslexic()==2||abc.getDyslexic()==4||abc.getDyslexic()==6||abc.getDyslexic()==8||abc.getDyslexic()==10||abc.getDyslexic()==12||abc.getDyslexic()==14||abc.getDyslexic()==16||abc.getDyslexic()==18||abc.getDyslexic()==20||abc.getDyslexic()==22||abc.getDyslexic()==24||abc.getDyslexic()==26||abc.getDyslexic()==28||abc.getDyslexic()==30||abc.getDyslexic()==32||abc.getDyslexic()==34) {

            dys = Typeface.createFromAsset(getAssets(), "fonts/sans.ttf");
            subject.setTypeface(dys);
            query.setTypeface(dys);
            send.setTypeface(dys);
            textView.setTypeface(dys);


        }else{


            dys = Typeface.createFromAsset(getAssets(), "fonts/dyslexic.ttf");
            subject.setTypeface(dys);
            query.setTypeface(dys);
            send.setTypeface(dys);
            textView.setTypeface(dys);
        }

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(("mailto:"+"yashjaiswal1@outlook.com")));
                intent.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,query.getText().toString());
                startActivity(intent);

            }
        });

    }
}

package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Enquiry extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Enquiry.this,Dashboard.class));super.onBackPressed();
    }
    EditText subject;
    EditText query;
    Button send;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);

        subject = (EditText) findViewById(R.id.editText);
        query = (EditText) findViewById(R.id.editText2);
        send = findViewById(R.id.Send);

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

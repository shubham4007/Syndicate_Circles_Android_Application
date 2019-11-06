package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class SplashScreen extends AppCompatActivity {

    private int SLEEP_TIMER = 2  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        LogoLauncher logoLauncher = new LogoLauncher();
        logoLauncher.start();

        Uri uri = Uri.parse("abcd");
        uri = getIntent().getData();
        if(uri!=null){
            Log.i("abcdef",uri.toString());
            List<String> params = uri.getPathSegments();
           global abc = (global) getApplicationContext();
           abc.setDeep_link(1);

        }



    }

    private class LogoLauncher extends Thread{
        public void run(){
            try{
                sleep(1000 * SLEEP_TIMER);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);
            SplashScreen.this.finish();
        }
    }
}

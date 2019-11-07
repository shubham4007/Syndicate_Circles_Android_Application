package com.example.afinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import static com.facebook.FacebookSdk.getApplicationContext;


public class Global_fragment extends Fragment {

    TextView lead_converted;
    TextView percentage;
    TextView name_regional;
    int percent;
    int leads;
    int leadc;

    View view;
    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        view = inflater.inflate(R.layout.globallead_fragment, container, false);
        global Global = (global) getApplicationContext();

        name_regional = view.findViewById(R.id.name_regional);
        lead_converted = view.findViewById(R.id.lead_converted);
        percentage = view.findViewById(R.id.percentage);

        leads = Integer.parseInt(Global.getLead());
        leadc = Integer.parseInt(Global.getLeadConverted());

        if(leads!=0) {
            percent = ((leadc / leads) * 100);
            percentage.setText(percent+"%");

        }
        lead_converted.setText(Global.getLeadConverted());


        name_regional.setText(Global.getName());



        return view;



    }

}

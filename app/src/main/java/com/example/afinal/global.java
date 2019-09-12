package com.example.afinal;

import android.app.Application;

public class global extends Application {

    private  String password;
    private  String name;
    private  String email;
    private  String region;
    private  String number = "1234567890";
    private String LeadConverted = "0";
    private String Lead = "0";
    private String points = "0";
    private int auth = 1;
    private  String count ;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public int getAuth() {
        return auth;
    }

    public void setAuth(int auth) {
        this.auth = auth;
    }

    public String getLeadConverted() {
        return LeadConverted;
    }

    public void setLeadConverted(String leadConverted) {
        LeadConverted = leadConverted;
    }

    public String getLead() {
        return Lead;
    }

    public void setLead(String lead) {
        Lead = lead;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}

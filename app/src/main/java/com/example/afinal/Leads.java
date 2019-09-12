package com.example.afinal;

public class Leads {
    private  String name;
    private  String email;

    private  String age;
    private  String product;
    private String date;
    private String refer;

    public Leads(String name, String email, String age, String product, String date, String refer) {
        this.name = name;
        this.email = email;

        this.age = age;
        this.product = product;
        this.date = date;
        this.refer = refer;
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

    public Leads() {
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


}

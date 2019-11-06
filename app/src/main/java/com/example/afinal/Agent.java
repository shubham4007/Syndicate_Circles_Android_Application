package com.example.afinal;

public class Agent {


        private String name;
        private String email;
        private String state;
        private String password ;
        private String phone = "1234567890";
        private String leadConverted = "0";
        private String lead = "0";
        private String points = "0";
        private String payment = "N.A.";

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getLeadConverted() {
        return leadConverted;
    }

    public void setLeadConverted(String leadConverted) {
        leadConverted = leadConverted;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        lead = lead;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public Agent() {
        }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

}

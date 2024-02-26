package com.example.store3;

public class User {
    String email;
    String pass;
    String address;



    public  User(String email,String pass, String address){
        this.address = address;
        this.email = email;
        this.pass = pass;

    }
    public String getEmail(){return email;}
    public  String getAddress(){return address;}
    public String getPass(){return pass;}

}

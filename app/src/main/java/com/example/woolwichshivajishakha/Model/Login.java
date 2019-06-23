package com.example.woolwichshivajishakha.Model;

public class Login {
    private String Email;
    private String Password;

    public Login(){

    }

    public Login(String email, String password){
        Email = email;
        Password = password;

    }

    public String getEmail(){
        return Email;
    }

    public void setEmail(String email){
        Email = email;
    }

    public String getPassword(){
        return Password;
    }

    public void setPassword(String password){
        Password = password;
    }


}

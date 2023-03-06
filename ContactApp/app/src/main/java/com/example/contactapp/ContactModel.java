package com.example.contactapp;

public class ContactModel {

    String uname, ucontact, uemail;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUcontact() {
        return ucontact;
    }

    public void setUcontact(String ucontact) {
        this.ucontact = ucontact;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public ContactModel(String uname, String ucontact, String uemail) {
        this.uname = uname;
        this.ucontact = ucontact;
        this.uemail = uemail;
    }

    @Override
    public String toString() {
        return "ContactModel{" +
                "uname='" + uname + '\'' +
                ", ucontact='" + ucontact + '\'' +
                ", uemail='" + uemail + '\'' +
                '}';
    }
}

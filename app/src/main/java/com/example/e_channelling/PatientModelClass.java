package com.example.e_channelling;

public class PatientModelClass {

    Integer nic;
    String firstname;
    String lastname;
    String email;
    String contact;
    String age;



    public PatientModelClass(String firstname, String lastname, String email, String contact, String age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.contact = contact;
        this.age = age;


    }

    public PatientModelClass(Integer nic, String firstname, String lastname, String email, String contact, String age) {
        this.nic = nic;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.contact = contact;
        this.age = age;


    }

    public Integer getNic() {
        return nic;
    }

    public void setNic(Integer nic) {
        this.nic = nic;
    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

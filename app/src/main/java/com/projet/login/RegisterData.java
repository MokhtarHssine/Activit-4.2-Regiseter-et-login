package com.projet.login;

public class RegisterData {
    int _id;
    String first_name;
    String last_name;
    String email_id;
    String dateNaissance;
    String sexe;
    String password;

    // Empty constructor
    public RegisterData() {
    }

    // constructor
    public RegisterData(int id, String first_name, String last_name, String email_id, String password, String dateNaissance) {
        this._id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_id = email_id;
        this.dateNaissance = dateNaissance;
        this.password = password;
    }

    // getting password
    public String getPassword() {
        return password;
    }

    // setting password
    public void setPassword(String password) {
        this.password = password;
    }

    // getting sexe
    public String getSexe() {
        return sexe;
    }

    // setting sexe
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    // getting ID
    public int getID() {
        return this._id;
    }

    // setting id
    public void setID(int id) {
        this._id = id;
    }

    // getting  first name
    public String getfirstName() {
        return first_name;
    }

    // setting  first name
    public void setfirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getlastName() {
        return last_name;
    }

    public void setlastName(String last_name) {
        this.last_name = last_name;
    }

    public String getEmailId() {
        return email_id;
    }

    public void setEmailId(String email_id) {
        this.email_id = email_id;
    }

    public String getDateNaiss() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}

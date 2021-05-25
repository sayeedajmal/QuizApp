package com.Quiz;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

public class GetterSitter {
    public JFXTextField login_name;
    public JFXPasswordField login_password;
    String wow[];
    String temp_username;

    public String[] getWow() {
        return wow;
    }

    public void setWow(String[] wow) {
        this.wow = wow;
    }

    public String getTemp_username() {
        return temp_username;
    }

    public void setTemp_username(String temp_username) {
        this.temp_username = temp_username;
    }

    public JFXTextField getLogin_name() {
        return login_name;
    }

    public void setLogin_name(JFXTextField login_name) {
        this.login_name = login_name;
    }

    public JFXPasswordField getLogin_password() {
        return login_password;
    }

    public void setLogin_password(JFXPasswordField login_password) {
        this.login_password = login_password;
    }

    public JFXTextField getSignup_name() {
        return signup_name;
    }

    public void setSignup_name(JFXTextField signup_name) {
        this.signup_name = signup_name;
    }

    public JFXPasswordField getSignup_password() {
        return signup_password;
    }

    public void setSignup_password(JFXPasswordField signup_password) {
        this.signup_password = signup_password;
    }

    public JFXTextField signup_name = new JFXTextField();
    public JFXPasswordField signup_password = new JFXPasswordField();

    public GetterSitter(JFXTextField login_name, JFXPasswordField login_password, JFXTextField signup_name,
            JFXPasswordField signup_password) {
        this.login_name = login_name;
        this.login_password = login_password;
        this.signup_name = signup_name;
        this.signup_password = signup_password;
    }
}

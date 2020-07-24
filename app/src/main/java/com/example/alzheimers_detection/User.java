package com.example.alzheimers_detection;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;

import java.util.Date;

public class User {
    String firstname,lastname,gender;
    String username;
    String birthdate;
    float executiveFunctioning,naming,abstraction,calculation,orientation,immediateRecall,attention,visuoperception,fluency,delayedRecall;
    String QRC;
    public User()
    {
    }
    User(String fname,String lname,String pusername)
    {
        firstname=fname;
        lastname=lname;
        username=pusername;

    }
    public User(String fname,String lname,String pgender,String pusername,String pbirthdate,String pqrc)
    {
        QRC=pqrc;
        firstname=fname;
        lastname=lname;
        gender=pgender;
        username=pusername;
        birthdate=pbirthdate;
    }

    public float getImmediateRecall() {
        return immediateRecall;
    }

    public void setImmediateRecall(float immediateRecall) {
        this.immediateRecall = immediateRecall;
    }

    public float getVisuoperception() {
        return visuoperception;
    }

    public void setVisuoperception(float visuoperception) {
        this.visuoperception = visuoperception;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQRC() {
        return QRC;
    }

    public void setQRC(String QRC) {
        this.QRC = QRC;
    }

    public float getOrientation() {
        return orientation;
    }

    public void setOrientation(float orientation) {
        this.orientation = orientation;
    }

    public float getNaming() {
        return naming;
    }

    public void setNaming(float naming) {
        this.naming = naming;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getFluency() {
        return fluency;
    }

    public void setFluency(float fluency) {
        this.fluency = fluency;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public float getExecutiveFunctioning() {
        return executiveFunctioning;
    }

    public void setExecutiveFunctioning(float executiveFunctioning) {
        this.executiveFunctioning = executiveFunctioning;
    }

    public float getDelayedRecall() {
        return delayedRecall;
    }

    public void setDelayedRecall(float delayedRecall) {
        this.delayedRecall = delayedRecall;
    }

    public float getCalculation() {
        return calculation;
    }

    public void setCalculation(float calculation) {
        this.calculation = calculation;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public float getAttention() {
        return attention;
    }

    public void setAttention(float attention) {
        this.attention = attention;
    }

    public float getAbstraction() {
        return abstraction;
    }

    public void setAbstraction(float abstraction) {
        this.abstraction = abstraction;
    }
}


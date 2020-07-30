package com.example.alzheimers_detection;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;

import java.util.Date;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;

import java.util.Date;

public class User {
    int closerelative;
    float executiveFunctioning;
    float naming;
    float abstraction;
    float calculation;
    float orientation;
    float immediateRecall;
    float attention;
    float visuoperception;
    float fluency;
    float delayedRecall;
    float carryingOutMyDailyActivities;
    float mood;
    float imWorkingIfeel;
    float sleepCycle;
    float experienceBodyPain;
    float starRating;
    float totalBehaviouralScore,floatTotalScore;
    String firstname,lastname,gender;
    String username;
    String birthdate;
    int countProgressHistory;
    int behaviouralResultOrNot;
    int headinjury;
    int cardiovasculardisease;
    int downsyndrome;
    int levelofeducation;
    int smoking;
    int drinking;
    int numOfScores=0,score1,score2,score3,score4,score5;
    String textFile;

    public String getTextFile() {
        return textFile;
    }

    public void setTextFile(String textFile) {
        this.textFile = textFile;
    }

    public int getScore5() {
        return score5;
    }

    public void setScore5(int score5) {
        this.score5 = score5;
    }

    public int getScore4() {
        return score4;
    }

    public void setScore4(int score4) {
        this.score4 = score4;
    }

    public int getScore3() {
        return score3;
    }

    public void setScore3(int score3) {
        this.score3 = score3;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getNumOfScores() {
        return numOfScores;
    }

    public void setNumOfScores(int numOfScores) {
        this.numOfScores = numOfScores;
    }

    float totalFamilyHistoryScore;



    public float getTotalfamilyscore() {
        return totalfamilyscore;
    }

    public void setTotalfamilyscore(float totalfamilyscore) {
        this.totalfamilyscore = totalfamilyscore;
    }

    float totalfamilyscore;

    public float getTotalBehaviouralScore() {
        return totalBehaviouralScore;
    }

    public void setTotalBehaviouralScore(float totalBehaviouralScore) {
        this.totalBehaviouralScore = totalBehaviouralScore;
    }

    public float getTotalFamilyHistoryScore() {
        return totalFamilyHistoryScore;
    }

    public void setTotalFamilyHistoryScore(float totalFamilyHistoryScore) {
        this.totalFamilyHistoryScore = totalFamilyHistoryScore;
    }


    public float getStarRating() {
        return starRating;
    }

    public void setStarRating(float starRating) {
        this.starRating = starRating;
    }

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

    public int getSmoking() {
        return smoking;
    }

    public void setSmoking(int smoking) {
        this.smoking = smoking;
    }

    public int getLevelofeducation() {
        return levelofeducation;
    }

    public void setLevelofeducation(int levelofeducation) {
        this.levelofeducation = levelofeducation;
    }

    public int getHeadinjury() {
        return headinjury;
    }

    public void setHeadinjury(int headinjury) {
        this.headinjury = headinjury;
    }

    public int getDrinking() {
        return drinking;
    }

    public void setDrinking(int drinking) {
        this.drinking = drinking;
    }

    public int getDownsyndrome() {
        return downsyndrome;
    }

    public void setDownsyndrome(int downsyndrome) {
        this.downsyndrome = downsyndrome;
    }

    public int getCardiovasculardisease() {
        return cardiovasculardisease;
    }

    public void setCardiovasculardisease(int cardiovasculardisease) {
        this.cardiovasculardisease = cardiovasculardisease;
    }

    public int getCloserelative() {
        return closerelative;
    }

    public void setCloserelative(int closerelative) {
        this.closerelative = closerelative;
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

    public int getBehaviouralResultOrNot() {
        return behaviouralResultOrNot;
    }

    public void setBehaviouralResultOrNot(int behaviouralResultOrNot) {
        this.behaviouralResultOrNot = behaviouralResultOrNot;
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

    public int getCountProgressHistory() {
        return countProgressHistory;
    }

    public void setCountProgressHistory(int countProgressHistory) {
        this.countProgressHistory = countProgressHistory;
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

    public float getCarryingOutMyDailyActivities() {
        return carryingOutMyDailyActivities;
    }

    public void setCarryingOutMyDailyActivities(float carryingOutMyDailyActivities) {
        this.carryingOutMyDailyActivities = carryingOutMyDailyActivities;
    }

    public float getExperienceBodyPain() {
        return experienceBodyPain;
    }

    public float getImWorkingIfeel() {
        return imWorkingIfeel;
    }

    public float getMood() {
        return mood;
    }

    public float getSleepCycle() {
        return sleepCycle;
    }

    public void setSleepCycle(float sleepCycle) {
        this.sleepCycle = sleepCycle;
    }

    public void setMood(float mood) {
        this.mood = mood;
    }

    public void setImWorkingIfeel(float imWorkingIfeel) {
        this.imWorkingIfeel = imWorkingIfeel;
    }

    public void setExperienceBodyPain(float experienceBodyPain) {
        this.experienceBodyPain = experienceBodyPain;
    }
}



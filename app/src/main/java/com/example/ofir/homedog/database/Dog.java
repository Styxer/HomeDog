package com.example.ofir.homedog.database;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dog_table")
public class Dog implements Parcelable {

    @PrimaryKey(autoGenerate = false)
    @NonNull
    private String id;

    private String DOB;

    private String age;

    private String arrived;

    @ColumnInfo(name = "brief_character")
    private String briefCharacter;

    @ColumnInfo(name = "brief_history")
    private String briefHistory;

    @ColumnInfo(name = "extra_details")
    private String extraDetails;

    @ColumnInfo(name = "getting_along_with_dogs")
    private String gettingAlongWithDogs;

    private String leash;

    private String name;

    private String phone;

    private String race;

    private String sex;

    private String status;

    @ColumnInfo(name = "suitable_for_children")
    private String suitableForChildren;

    @ColumnInfo(name = "time_in_kennel")
    private String timeInKennel;

    private String trained;

    @ColumnInfo(name = "image_url")
    private String imageUrl;

    public Dog(String id, String DOB, String age, String arrived, String briefCharacter, String briefHistory, String extraDetails, String gettingAlongWithDogs, String leash, String name, String phone, String race, String sex, String status, String suitableForChildren, String timeInKennel, String trained, String imageUrl) {
        this.id = id;
        this.DOB = DOB;
        this.age = age;
        this.arrived = arrived;
        this.briefCharacter = briefCharacter;
        this.briefHistory = briefHistory;
        this.extraDetails = extraDetails;
        this.gettingAlongWithDogs = gettingAlongWithDogs;
        this.leash = leash;
        this.name = name;
        this.phone = phone;
        this.race = race;
        this.sex = sex;
        this.status = status;
        this.suitableForChildren = suitableForChildren;
        this.timeInKennel = timeInKennel;
        this.trained = trained;
        this.imageUrl = imageUrl;
    }

    protected Dog(Parcel in) {
        id = in.readString();
        DOB = in.readString();
        age = in.readString();
        arrived = in.readString();
        briefCharacter = in.readString();
        briefHistory = in.readString();
        extraDetails = in.readString();
        gettingAlongWithDogs = in.readString();
        leash = in.readString();
        name = in.readString();
        phone = in.readString();
        race = in.readString();
        sex = in.readString();
        status = in.readString();
        suitableForChildren = in.readString();
        timeInKennel = in.readString();
        trained = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<Dog> CREATOR = new Creator<Dog>() {
        @Override
        public Dog createFromParcel(Parcel in) {
            return new Dog(in);
        }

        @Override
        public Dog[] newArray(int size) {
            return new Dog[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getArrived() {
        return arrived;
    }

    public void setArrived(String arrived) {
        this.arrived = arrived;
    }

    public String getBriefCharacter() {
        return briefCharacter;
    }

    public void setBriefCharacter(String briefCharacter) {
        this.briefCharacter = briefCharacter;
    }

    public String getBriefHistory() {
        return briefHistory;
    }

    public void setBriefHistory(String briefHistory) {
        this.briefHistory = briefHistory;
    }

    public String getExtraDetails() {
        return extraDetails;
    }

    public void setExtraDetails(String extraDetails) {
        this.extraDetails = extraDetails;
    }

    public String getGettingAlongWithDogs() {
        return gettingAlongWithDogs;
    }

    public void setGettingAlongWithDogs(String gettingAlongWithDogs) {
        this.gettingAlongWithDogs = gettingAlongWithDogs;
    }

    public String getLeash() {
        return leash;
    }

    public void setLeash(String leash) {
        this.leash = leash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSuitableForChildren() {
        return suitableForChildren;
    }

    public void setSuitableForChildren(String suitableForChildren) {
        this.suitableForChildren = suitableForChildren;
    }

    public String getTimeInKennel() {
        return timeInKennel;
    }

    public void setTimeInKennel(String timeInKennel) {
        this.timeInKennel = timeInKennel;
    }

    public String getTrained() {
        return trained;
    }

    public void setTrained(String trained) {
        this.trained = trained;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(DOB);
        dest.writeString(age);
        dest.writeString(arrived);
        dest.writeString(briefCharacter);
        dest.writeString(briefHistory);
        dest.writeString(extraDetails);
        dest.writeString(gettingAlongWithDogs);
        dest.writeString(leash);
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeString(race);
        dest.writeString(sex);
        dest.writeString(status);
        dest.writeString(suitableForChildren);
        dest.writeString(timeInKennel);
        dest.writeString(trained);
        dest.writeString(imageUrl);
    }
}

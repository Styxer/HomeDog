package com.example.ofir.homedog.database;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.Timestamp;

import java.util.List;




public class Dog implements Parcelable {

    private  String  chipNumber;

    private  String name;

    private String gender;

    private Timestamp birthday;

    private Double age;


    private Timestamp arrivedToTheShelterAt;


    private  String timeAtTheShelter;

    private String friends;


    private String shortHistory;

    private String character;


    private  String getsAlongWithDogs;


    private  String getsAlongWithChildren;


    private  String pottyTrained;


    private  String  walkingWithALeash;

    private  String status;


    private  String adoptersName;


    private  String adoptersPhoneNumber;

    private  String comments;


    private List<String> image_urls;


    public Dog() {
        //empty constructor needed
    }

    public Dog(String chipNumber, String name, String gender, Timestamp birthday, Double age, Timestamp arrivedToTheShelterAt, String timeAtTheShelter, String friends, String shortHistory, String character, String getsAlongWithDogs, String getsAlongWithChildren, String pottyTrained, String walkingWithALeash, String status, String adoptersName, String adoptersPhoneNumber, String comments, List<String> image_urls) {
        this.chipNumber = chipNumber;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
        this.arrivedToTheShelterAt = arrivedToTheShelterAt;
        this.timeAtTheShelter = timeAtTheShelter;
        this.friends = friends;
        this.shortHistory = shortHistory;
        this.character = character;
        this.getsAlongWithDogs = getsAlongWithDogs;
        this.getsAlongWithChildren = getsAlongWithChildren;
        this.pottyTrained = pottyTrained;
        this.walkingWithALeash = walkingWithALeash;
        this.status = status;
        this.adoptersName = adoptersName;
        this.adoptersPhoneNumber = adoptersPhoneNumber;
        this.comments = comments;
        this.image_urls = image_urls;
    }

    protected Dog(Parcel in) {
        chipNumber = in.readString();
        name = in.readString();
        gender = in.readString();
        birthday = in.readParcelable(Timestamp.class.getClassLoader());
        if (in.readByte() == 0) {
            age = null;
        } else {
            age = in.readDouble();
        }
        arrivedToTheShelterAt = in.readParcelable(Timestamp.class.getClassLoader());
        timeAtTheShelter = in.readString();
        friends = in.readString();
        shortHistory = in.readString();
        character = in.readString();
        getsAlongWithDogs = in.readString();
        getsAlongWithChildren = in.readString();
        pottyTrained = in.readString();
        walkingWithALeash = in.readString();
        status = in.readString();
        adoptersName = in.readString();
        adoptersPhoneNumber = in.readString();
        comments = in.readString();
        image_urls = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(chipNumber);
        dest.writeString(name);
        dest.writeString(gender);
        dest.writeParcelable(birthday, flags);
        if (age == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(age);
        }
        dest.writeParcelable(arrivedToTheShelterAt, flags);
        dest.writeString(timeAtTheShelter);
        dest.writeString(friends);
        dest.writeString(shortHistory);
        dest.writeString(character);
        dest.writeString(getsAlongWithDogs);
        dest.writeString(getsAlongWithChildren);
        dest.writeString(pottyTrained);
        dest.writeString(walkingWithALeash);
        dest.writeString(status);
        dest.writeString(adoptersName);
        dest.writeString(adoptersPhoneNumber);
        dest.writeString(comments);
        dest.writeStringList(image_urls);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getChipNumber() {
        return chipNumber;
    }

    public void setChipNumber(String chipNumber) {
        this.chipNumber = chipNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Timestamp getArrivedToTheShelterAt() {
        return arrivedToTheShelterAt;
    }

    public void setArrivedToTheShelterAt(Timestamp arrivedToTheShelterAt) {
        this.arrivedToTheShelterAt = arrivedToTheShelterAt;
    }

    public String getTimeAtTheShelter() {
        return timeAtTheShelter;
    }

    public void setTimeAtTheShelter(String timeAtTheShelter) {
        this.timeAtTheShelter = timeAtTheShelter;
    }

    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    public String getShortHistory() {
        return shortHistory;
    }

    public void setShortHistory(String shortHistory) {
        this.shortHistory = shortHistory;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getGetsAlongWithDogs() {
        return getsAlongWithDogs;
    }

    public void setGetsAlongWithDogs(String getsAlongWithDogs) {
        this.getsAlongWithDogs = getsAlongWithDogs;
    }

    public String getGetsAlongWithChildren() {
        return getsAlongWithChildren;
    }

    public void setGetsAlongWithChildren(String getsAlongWithChildren) {
        this.getsAlongWithChildren = getsAlongWithChildren;
    }

    public String getPottyTrained() {
        return pottyTrained;
    }

    public void setPottyTrained(String pottyTrained) {
        this.pottyTrained = pottyTrained;
    }

    public String getWalkingWithALeash() {
        return walkingWithALeash;
    }

    public void setWalkingWithALeash(String walkingWithALeash) {
        this.walkingWithALeash = walkingWithALeash;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdoptersName() {
        return adoptersName;
    }

    public void setAdoptersName(String adoptersName) {
        this.adoptersName = adoptersName;
    }

    public String getAdoptersPhoneNumber() {
        return adoptersPhoneNumber;
    }

    public void setAdoptersPhoneNumber(String adoptersPhoneNumber) {
        this.adoptersPhoneNumber = adoptersPhoneNumber;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<String> getImage_urls() {
        return image_urls;
    }

    public void setImage_urls(List<String> image_urls) {
        this.image_urls = image_urls;
    }
}

package com.example.ofir.homedog.database;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.ofir.homedog.database.localDB.ImageUrlsTypeConverters;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = "dog_table")
public class Dog implements Parcelable {

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "chip_number")
    @NonNull
    private  String  chipNumber;

    private  String name;

    private String gender;

    private String birthday;

    private String age;

    @ColumnInfo(name = "arrived_to_the_shelter_at")
    private String arrivedToTheShelterAt;

    @ColumnInfo(name = "time_at_the_shelter")
    private  String timeAtTheShelter;

    private String friends;

    @ColumnInfo(name = "short_history")
    private String shortHistory;

    private String character;

    @ColumnInfo(name = "gets_along_with_dogs")
    private  String getsAlongWithDogs;

    @ColumnInfo(name = "gets_along_with_children")
    private  String getsAlongWithChildren;

    @ColumnInfo(name = "potty_trained")
    private  String pottyTrained;

    @ColumnInfo(name = "walking_with_a_leash")
    private  String  walkingWithALeash;

    private  String status;

    @ColumnInfo(name = "adopters_name")
    private  String adoptersName;

    @ColumnInfo(name = "adopters_phone_number")
    private  String adoptersPhoneNumber;

    private  String comments;

    @TypeConverters(ImageUrlsTypeConverters.class)
    private List<String> image_urls;


    public Dog(String chipNumber, String name, String gender, String birthday, String age, String arrivedToTheShelterAt, String timeAtTheShelter, String friends, String shortHistory, String character, String getsAlongWithDogs, String getsAlongWithChildren, String pottyTrained, String walkingWithALeash, String status, String adoptersName, String adoptersPhoneNumber, String comments, List<String> image_urls) {
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
        birthday = in.readString();
        age = in.readString();
        arrivedToTheShelterAt = in.readString();
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getArrivedToTheShelterAt() {
        return arrivedToTheShelterAt;
    }

    public void setArrivedToTheShelterAt(String arrivedToTheShelterAt) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(chipNumber);
        dest.writeString(name);
        dest.writeString(gender);
        dest.writeString(birthday);
        dest.writeString(age);
        dest.writeString(arrivedToTheShelterAt);
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
}

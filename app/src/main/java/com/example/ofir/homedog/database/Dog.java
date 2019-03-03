package com.example.ofir.homedog.database;

import com.google.firebase.Timestamp;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dog_table")
public class Dog {

    @PrimaryKey(autoGenerate = false)
    @NonNull
    private long id;

    private String breed;

    private String name;

    private String gender;

    private Timestamp birthday;

    private Double age;

    private String status;

    private List<String> img_urls;

    public Dog() {
    }

    public Dog(String breed, String name, String gender, Timestamp birthday, Double age, String status, List<String> image_urls) {
        this.breed = breed;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
        this.status = status;
        img_urls = image_urls;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getImg_urls() {
        return img_urls;
    }

    public void setImg_urls(List<String> img_urls) {
        this.img_urls = img_urls;
    }
}

package com.example.ofir.homedog.ui.list;

import android.app.Application;

import com.example.ofir.homedog.database.Dog;
import com.example.ofir.homedog.HomeDogRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MainActivityViewModel extends AndroidViewModel {


    private HomeDogRepository repository;
    private LiveData<List<Dog>> allDogs;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        repository = new HomeDogRepository(application);
        allDogs  = repository.getAllDogs();
    }

    public void insert(Dog dog){
        repository.insert(dog);
    }

    public void update(Dog dog){
        repository.update(dog);
    }

    public  void delete(Dog dog){
        repository.delete(dog);
    }

    public void deleteAllDogs(){
        repository.deleteAllDogs();
    }

    public LiveData<List<Dog>> getAllDogs(){
        return  allDogs;
    }
}

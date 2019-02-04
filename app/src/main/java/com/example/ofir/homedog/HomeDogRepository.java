package com.example.ofir.homedog;

import android.app.Application;
import android.os.AsyncTask;

import com.example.ofir.homedog.Database.Dog;
import com.example.ofir.homedog.Database.DogDao;
import com.example.ofir.homedog.Database.HomeDogDatabase;

import java.util.List;

import androidx.lifecycle.LiveData;

public class HomeDogRepository {

    private DogDao dogDao;
    private LiveData<List<Dog>> allDogs;

    public HomeDogRepository(Application application) {
        HomeDogDatabase database = HomeDogDatabase.getInstance(application);
        dogDao = database.dogDao();

        allDogs = dogDao.getAllDogsById();
    }

    public void insert(Dog dog){
        new InsertDogAsyncTask(dogDao).execute(dog);
    }

    public  void update(Dog dog){
        new UpdateDogAsyncTask(dogDao).execute(dog);
    }

    public void delete(Dog dog){
        new DeleteDogAsyncTask(dogDao).execute(dog);
    }

    public void deleteAllDogs(){
        new DeleteAllDogAsyncTask(dogDao).execute();
    }

    public LiveData<List<Dog>> getAllDogs() {
        return allDogs;
    }


    ///////////////////////////////////////////
    private static class InsertDogAsyncTask extends AsyncTask<Dog, Void, Void>{

        private DogDao dogDao;

        private InsertDogAsyncTask(DogDao dogDao) {
            this.dogDao = dogDao;
        }

        @Override
        protected Void doInBackground(Dog... dogs) {
            dogDao.insert(dogs[0]);
            return null;
        }
    }

    private static class UpdateDogAsyncTask extends AsyncTask<Dog, Void, Void>{

        private DogDao dogDao;

        private UpdateDogAsyncTask(DogDao dogDao) {
            this.dogDao = dogDao;
        }

        @Override
        protected Void doInBackground(Dog... dogs) {
            dogDao.update(dogs[0]);
            return null;
        }
    }

    private static class DeleteDogAsyncTask extends AsyncTask<Dog, Void, Void>{

        private DogDao dogDao;

        private DeleteDogAsyncTask(DogDao dogDao) {
            this.dogDao = dogDao;
        }

        @Override
        protected Void doInBackground(Dog... dogs) {
            dogDao.delete(dogs[0]);
            return null;
        }
    }

    private static class DeleteAllDogAsyncTask extends AsyncTask<Void, Void, Void>{

        private DogDao dogDao;

        private DeleteAllDogAsyncTask(DogDao dogDao) {
            this.dogDao = dogDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dogDao.deleteAllNotes();
            return null;
        }
    }
}

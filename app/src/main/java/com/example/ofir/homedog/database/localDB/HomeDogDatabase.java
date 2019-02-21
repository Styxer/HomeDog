package com.example.ofir.homedog.database.localDB;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.ofir.homedog.database.Dog;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Dog.class}, version = 1, exportSchema = false)
public abstract class HomeDogDatabase extends RoomDatabase {

    private static final String TAG = HomeDogDatabase.class.getSimpleName();
    private static final String DATABASE_NAME = "HomeDog";

    private static HomeDogDatabase instance;
    private static final Object LOCK = new Object();

    public abstract DogDao dogDao();

    public static synchronized HomeDogDatabase getInstance(Context context) {
        Log.d(TAG, "Getting the database");

        if (instance == null) {
            synchronized (LOCK) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        HomeDogDatabase.class, DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .addCallback(callback)//TODO : DELETE FOR DEMO ONLY
                        .build();
            }
            Log.d(TAG, "Made new database");
        }

        return  instance;
    }

    //TODO : DELETE FOR DEMO ONLY
    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };



    //TODO : DELETE FOR DEMO ONLY
    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{

        private DogDao dogDao;

        public PopulateDbAsyncTask(HomeDogDatabase db) {
            dogDao = db.dogDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {






            return null;
        }
    }
}

package com.example.ofir.homedog.database;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

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
            dogDao.insert(
                    new Dog("990000000784874","2018-02-28T22:00:00.000Z","0.9", "2019-01-16T22:00:00.000Z","0.0", "חסר"
                            ,"הגיע מתל\"ל"   ,"חסר","חסר", "אלפא","חסר"
                            ,"בכלבייה", "זכר","בכלבייה","חסר","חסר",
                            "חסר","https://firebasestorage.googleapis.com/v0/b/bopo-152112.appspot.com/o/images%2FMarkel1.JPG?alt=media&token=1806c235-187a-4aae-91ba-1c7665e8f328"));
            dogDao.insert(
                    new Dog("990000000785206","2018-02-28T22:00:00.000Z","1.0", "2019-01-16T22:00:00.000Z","0.0", "חסר"
                            ,"הגיע מתל\"ל"   ,"חסר","חסר", "אשלי","חסר"
                            ,"בכלבייה", "נקבה","בכלבייה","חסר","חסר",
                            "חסר","https://firebasestorage.googleapis.com/v0/b/bopo-152112.appspot.com/o/images%2F%D7%90%D7%9C%D7%A4%D7%90_1.jpg?alt=media&token=5ecfc1a6-eb58-4737-b776-a6c28f361b4f"));




            return null;
        }
    }
}

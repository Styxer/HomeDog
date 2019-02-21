package com.example.ofir.homedog.ui.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.ofir.homedog.GlideApp;
import com.example.ofir.homedog.R;
import com.example.ofir.homedog.database.Dog;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivityAdapter extends FirestoreRecyclerAdapter<Dog, MainActivityAdapter.DogHolder> {

    private Context context;


    public MainActivityAdapter(@NonNull FirestoreRecyclerOptions<Dog> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull DogHolder dogHolder, int i, @NonNull Dog dog) {

        dogHolder.textViewDogName.setText(dog.getName());
        dogHolder.textViewDogAge.setText(String.valueOf(dog.getAge()));
        dogHolder.textViewDogStatus.setText(dog.getStatus());

        String profilePicture = dog.getImage_urls() == null ? " " : dog.getImage_urls().get(0);

        GlideApp.with(context)
                .load(profilePicture)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .circleCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(dogHolder.imageViewDogImage);
    }



    @NonNull
    @Override
    public DogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dog_list_item
                ,parent, false);

        return new DogHolder(view);
    }


    class DogHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewDogImage;
        private TextView textViewDogName, textViewDogAge, textViewDogStatus;


        public DogHolder(@NonNull View itemView) {
            super(itemView);

            imageViewDogImage = itemView.findViewById(R.id.image_view_dog_list_image);
            textViewDogName = itemView.findViewById(R.id.text_view_dog_list_name);
            textViewDogAge = itemView.findViewById(R.id.text_view_dog_list_age);
            textViewDogStatus = itemView.findViewById(R.id.text_view_dog_list_status);
        }
    }
}

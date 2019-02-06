package com.example.ofir.homedog.ui.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ofir.homedog.GlideApp;
import com.example.ofir.homedog.R;
import com.example.ofir.homedog.database.Dog;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.DogHolder> {


    private List<Dog> dogs = new ArrayList<>();
    private Context context;

    public MainActivityAdapter(Context context ) {
        this.context = context;
    }

    @NonNull
    @Override
    public DogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dog_list_item, parent, false);

        return new DogHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DogHolder holder, int position) {

        Dog currentDog = dogs.get(position);
        holder.textViewDogName.setText( currentDog.getName());
        holder.textViewDogAge.setText(currentDog.getAge());
        holder.textViewDogStatus.setText(currentDog.getStatus());

        String dogImage = currentDog.getImageUrl();

        GlideApp.with(context)
                .load(dogImage)
                .circleCrop()
                .into(holder.imageViewDogImage);

    }

    public void setDogs(List<Dog> dogs){
        this.dogs = dogs;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dogs.size();
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

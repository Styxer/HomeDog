package com.example.ofir.homedog.ui.list;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.example.ofir.homedog.GlideApp;
import com.example.ofir.homedog.R;
import com.example.ofir.homedog.database.Dog;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.firebase.ui.firestore.paging.LoadingState;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivityAdapter extends FirestorePagingAdapter<Dog, MainActivityAdapter.DogHolder> { //FirestoreRecyclerAdapter<Dog, MainActivityAdapter.DogHolder> {

    private Context context;
    private ProgressBar progressBar;
    private CollectionReference dogRef;
    /**
     * Construct a new FirestorePagingAdapter from the given {@link FirestorePagingOptions}.
     *
     * @param options
     */
    public MainActivityAdapter(@NonNull FirestorePagingOptions<Dog> options,  ProgressBar progressBar, Context context) {
        super(options);
        this.context = context;
        this.progressBar = progressBar;
        dogRef = FirebaseFirestore.getInstance().collection("HomeDog");
    }


 /*   public MainActivityAdapter(@NonNull FirestoreRecyclerOptions<Dog> options, Context context) {
        super(options);
        this.context = context;
    }*/

    @Override
    protected void onBindViewHolder(@NonNull DogHolder dogHolder, int i, @NonNull Dog dog) {

        Double age = Math.round(dog.getAge() * 10D) / 10D;

        if (dog.getName().equals("אלפא"))
            age = age;

        dogHolder.textViewDogName.setText(dog.getName());
        dogHolder.textViewDogAge.setText(String.valueOf(age));
        dogHolder.textViewDogStatus.setText(dog.getStatus());

        if (dog.getGender().equals("זכר")) {
           // dogHolder.imageViewDogGender.setBackgroundResource(R.drawable.male_dog);
          //  dogHolder.
           // dogHolder.cardView.setBackgroundColor(Color.parseColor("#3BBEE9"));
            dogHolder.circularImageView.setBorderColor(Color.parseColor("#3BBEE9"));
        } else{
            if (dog.getGender().equals("נקבה"))
               // dogHolder.cardView.setBackgroundColor(Color.parseColor("#EF80B1"));
                dogHolder.circularImageView.setBorderColor(Color.parseColor("#EF80B1"));
             //   dogHolder.imageViewDogGender.setBackgroundResource(R.drawable.female_dog);
        }

        String profilePicture = dog.getImg_urls() == null ?
                "https://cdn.clipart.email/c1e6217009fd71d3ebd178488ca8980c_dog-silhouette-images-stock-photos-vectors-shutterstock_239-280.png"
                : dog.getImg_urls().get(0);

        GlideApp.with(context)
                .load(profilePicture)
                //.centerCrop()
               // .placeholder(R.drawable.ic_launcher_background)
              //  .circleCrop()
            .listener(new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    return false;
                }

                @Override
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    return false;
                }
            })



        . into(dogHolder.circularImageView);
           //
    }


    @NonNull
    @Override
    public DogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dog_list_item
                        , parent, false);

        return new DogHolder(view);
    }

    @Override
    protected void onLoadingStateChanged(@NonNull LoadingState state) {
      //  super.onLoadingStateChanged(state);
        switch (state) {
            case LOADING_INITIAL:
            case LOADING_MORE:
                progressBar.setVisibility(View.VISIBLE);
                break;
            case LOADED:
                progressBar.setVisibility(View.GONE);
                break;
            case FINISHED:
                progressBar.setVisibility(View.GONE);
                Toast.makeText(context, "Reached end of data set.", Toast.LENGTH_SHORT).show();
                break;
            case ERROR:
               // showToast("An error occurred.");
                Toast.makeText(context, "An error occurred.", Toast.LENGTH_SHORT).show();
                retry();
                break;
        }
    }


    class DogHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewDogImage, imageViewDogGender;
        private TextView textViewDogName, textViewDogAge, textViewDogStatus;
        private CardView cardView;
        private  com.mikhaellopez.circularimageview.CircularImageView circularImageView;


        public DogHolder(@NonNull View itemView) {
            super(itemView);

            circularImageView  = itemView.findViewById(R.id.image_view_dog_list_image);
            textViewDogName = itemView.findViewById(R.id.text_view_dog_list_name);
            textViewDogAge = itemView.findViewById(R.id.text_view_dog_list_age);
            textViewDogStatus = itemView.findViewById(R.id.text_view_dog_list_status);
          //  imageViewDogGender = itemView.findViewById(R.id.image_view_dog_list_gender);
            cardView = itemView.findViewById(R.id.card_view_dog_list_item);
        }
    }
}

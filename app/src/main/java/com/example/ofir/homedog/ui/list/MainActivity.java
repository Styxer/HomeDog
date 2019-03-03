package com.example.ofir.homedog.ui.list;


import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.example.ofir.homedog.database.Dog;
import com.example.ofir.homedog.R;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;
import com.google.firebase.storage.FirebaseStorage;
import com.firebase.ui.firestore.paging.FirestorePagingAdapter;


import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements androidx.appcompat.widget.SearchView.OnQueryTextListener {

    private static final String TAG = MainActivity.class.getSimpleName();


    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference dogRef = db.collection("HomeDog");

    private MainActivityAdapter adapter;
    private ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        db.setFirestoreSettings(settings);

        progressBar = findViewById(R.id.paging_loading);

        setUpRecyclerView("");



    }

    private void setUpRecyclerView(String searchText) {

        Query query = dogRef.orderBy("name", Query.Direction.ASCENDING).startAt(searchText).endAt(searchText + "\uf8ff");

        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPrefetchDistance(5)
                .setPageSize(5)
                .setInitialLoadSizeHint(6)
                .build();


        FirestorePagingOptions<Dog> options = new FirestorePagingOptions.Builder<Dog>()
                .setLifecycleOwner(this)
                .setQuery(query, config, Dog.class)
                .build();

        /*FirestoreRecyclerOptions<Dog> options = new FirestoreRecyclerOptions.Builder<Dog>()
                .setQuery(query, Dog.class)
                .build();*/

        adapter = new MainActivityAdapter(options, progressBar, this);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_dog_list);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(this, 2, 10, true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //  adapter.stopListening();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView)menuItem.getActionView();

        SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
      //  SearchView search = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(manager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint("חפש");
        searchView.setOnQueryTextListener(this);

        return  true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        setUpRecyclerView(query);

        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}



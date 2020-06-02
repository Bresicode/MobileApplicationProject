package com.example.evilslides.library.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evilslides.R;
import com.example.evilslides.library.control.DataBuilder;


public class LibraryActivity extends AppCompatActivity {
    private static String TAG = "LibraryActivity";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private DataBuilder db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        db = new DataBuilder(this);

        //make recyclerview and fill it
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        myAdapter = new MyAdapter(db.getSlides());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);

    }

    public void startDeckEdit(View view) {
        Intent intent = new Intent(this, SlideEditActivity.class);
        startActivity(intent);
    }

}

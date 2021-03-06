package com.example.evilcards.library.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evilcards.R;
import com.example.evilcards.library.control.LibraryAccessorImpl;


public class LibraryActivity extends AppCompatActivity {
    private static String TAG = LibraryActivity.class.getName();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private LibraryAccessorImpl libraryAccessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
    }

    @Override
    protected void onResume() {
        super.onResume();
        libraryAccessor = new LibraryAccessorImpl(this);

        //make recyclerview and fill it
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        myAdapter = new MyAdapter(libraryAccessor.getCards());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);
    }

    public void startDeckEdit(View view) {
        Intent intent = new Intent(this, CardEditActivity.class);
        startActivity(intent);
    }

}

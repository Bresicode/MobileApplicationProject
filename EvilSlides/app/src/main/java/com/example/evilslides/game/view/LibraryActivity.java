package com.example.evilslides.game.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evilslides.R;
import com.example.evilslides.game.control.FileManager;
import com.example.evilslides.game.control.FileManagerImpl;
import com.example.evilslides.game.control.MyAdapter;
import com.example.evilslides.game.model.SlideImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;


public class LibraryActivity extends AppCompatActivity {
    private static String TAG = "LibraryActivity";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    FileManager fm;
    File file;
    List<SlideImpl> slides;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        //build data model from file
        file = new File(this.getFilesDir(), "data");
        fm = new FileManagerImpl();
        try {
            slides = fm.readFromFile(file, this);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //make recyclerview and fill it
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        myAdapter = new MyAdapter(slides);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);

    }

    public void startDeckEdit(View view) {
        Intent intent = new Intent(this, SlideEditActivity.class);
        startActivity(intent);
    }

}

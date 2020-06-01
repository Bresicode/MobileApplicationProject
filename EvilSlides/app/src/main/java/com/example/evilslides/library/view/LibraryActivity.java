package com.example.evilslides.library.view;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.evilslides.R;


public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
    }

    public void startDeckEdit(View view) {
        Intent intent = new Intent(this, SlideEditActivity.class);
        startActivity(intent);
    }
}

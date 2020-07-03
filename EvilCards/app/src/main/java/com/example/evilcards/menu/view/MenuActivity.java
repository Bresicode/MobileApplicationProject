package com.example.evilcards.menu.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.evilcards.R;
import com.example.evilcards.game.view.GameActivity;
import com.example.evilcards.library.view.LibraryActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void startLibrary(View view) {
        Intent intent = new Intent(this, LibraryActivity.class);
        startActivity(intent);
    }
}

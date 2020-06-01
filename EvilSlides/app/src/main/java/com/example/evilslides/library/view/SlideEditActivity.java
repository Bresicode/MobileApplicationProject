package com.example.evilslides.library.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import com.example.evilslides.R;
import com.example.evilslides.library.model.SlideImpl;

import java.util.ArrayList;
import java.util.List;

public class SlideEditActivity extends AppCompatActivity {
    EditText editText;
    CheckBox checkQuestion;
    List<SlideImpl> slides;
    private static String TAG = "DeckEditActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_edit);

        editText = findViewById(R.id.editSlideText);
        checkQuestion = findViewById(R.id.isquestioncheckbox);
        slides = new ArrayList<SlideImpl>();
    }

    public void slideHinzufuegen(View view) {
        String text = editText.getText().toString();
        boolean isQuestion = checkQuestion.isChecked();
        finish();
    }
}

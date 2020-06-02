package com.example.evilslides.game.view;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.evilslides.R;
import com.example.evilslides.game.control.FileManager;
import com.example.evilslides.game.control.FileManagerImpl;
import com.example.evilslides.game.model.SlideImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class SlideEditActivity extends AppCompatActivity {
    EditText editText;
    CheckBox checkQuestion;
    List<SlideImpl> slides;
    File file;
    FileManager fm;
    private static String TAG = "DeckEditActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_edit);

        editText = findViewById(R.id.editSlideText);
        checkQuestion = findViewById(R.id.isquestioncheckbox);
        fm = new FileManagerImpl();
        file = new File(this.getFilesDir(), "data");
        try {
            slides = fm.readFromFile(file, this);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void slideHinzufuegen(View view) {
        String text = editText.getText().toString();
        boolean isQuestion = checkQuestion.isChecked();
        slides.add(new SlideImpl(text, slides.size(), isQuestion));
        Toast toast = Toast.makeText(this, "Erfolgreich hinzugefügt!", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        fm.writeToFile(file, this, slides);
        Toast toast = Toast.makeText(this, "Erfolgreich in File abgespeichert!", Toast.LENGTH_SHORT);
        toast.show();
        finish();
    }

}

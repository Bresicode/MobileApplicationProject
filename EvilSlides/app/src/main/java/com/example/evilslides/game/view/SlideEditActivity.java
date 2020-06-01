package com.example.evilslides.game.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.evilslides.R;
import com.example.evilslides.game.control.FileManager;
import com.example.evilslides.game.control.FileManagerImpl;
import com.example.evilslides.game.model.SlideImpl;

import java.io.File;
import java.util.ArrayList;
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
        slides = new ArrayList<SlideImpl>();
        editText = findViewById(R.id.editSlideText);
        checkQuestion = findViewById(R.id.isquestioncheckbox);
        fm = new FileManagerImpl();
        //fm.readFromFile(file, this);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void slideHinzufuegen(View view) {
        String text = editText.getText().toString();
        boolean isQuestion = checkQuestion.isChecked();
        slides.add(new SlideImpl(text, slides.size(), isQuestion));
        Toast toast = Toast.makeText(this, "Erfolgreich hinzugefügt!", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void save(View view) {
        file = new File(this.getFilesDir(), "data");
        fm.writeToFile(file, this, slides);
        Toast toast = Toast.makeText(this, "Erfolgreich in File abgespeichert!", Toast.LENGTH_SHORT);
        toast.show();
        finish();
    }
}

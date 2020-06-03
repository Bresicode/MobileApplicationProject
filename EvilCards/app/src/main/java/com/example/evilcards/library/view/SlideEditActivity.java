package com.example.evilcards.library.view;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.evilcards.R;
import com.example.evilcards.library.control.LibraryAccessorImpl;
import com.example.evilcards.library.model.CardImpl;

public class SlideEditActivity extends AppCompatActivity {
    private static String TAG = "DeckEditActivity";
    EditText editText;
    CheckBox checkQuestion;
    LibraryAccessorImpl db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_edit);

        editText = findViewById(R.id.editSlideText);
        checkQuestion = findViewById(R.id.isquestioncheckbox);
        db = new LibraryAccessorImpl(this);

    }

    public void slideHinzufuegen(View view) {
        String text = editText.getText().toString();
        boolean isQuestion = checkQuestion.isChecked();
        db.getCards().add(new CardImpl(text, db.getCards().size(), isQuestion));
        Toast toast = Toast.makeText(this, "Erfolgreich hinzugefügt!", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        db.getFm().writeToFile(db.getFile(), this, db.getCards());
        Toast toast = Toast.makeText(this, "Erfolgreich in File abgespeichert!", Toast.LENGTH_SHORT);
        toast.show();
        finish();
    }

}

package com.example.evilcards.library.view;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.evilcards.R;
import com.example.evilcards.library.control.LibraryAccessorImpl;
import com.example.evilcards.library.model.CardImpl;

public class CardEditActivity extends AppCompatActivity {
    private static String TAG = CardEditActivity.class.getName();
    EditText editText;
    CheckBox checkQuestion;
    LibraryAccessorImpl libraryAccessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_edit);

        editText = findViewById(R.id.editCardText);
        checkQuestion = findViewById(R.id.isquestioncheckbox);
        libraryAccessor = new LibraryAccessorImpl(this);

    }

    public void cardHinzufuegen(View view) {
        String text = editText.getText().toString();
        boolean isQuestion = checkQuestion.isChecked();
        libraryAccessor.getCards().add(new CardImpl(text, libraryAccessor.getCards().size(), isQuestion));
        libraryAccessor.getFm().writeToFile(libraryAccessor.getCards());
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}

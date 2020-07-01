package com.example.evilcards.test;

import androidx.test.rule.ActivityTestRule;

import com.example.evilcards.library.view.LibraryActivity;

import org.junit.*;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


public class LibraryActivityTest {

    @Rule
    public ActivityTestRule<LibraryActivity> activityTestRule = new ActivityTestRule<>(LibraryActivity.class);


    @Test
    public void RecyclerViewTest() {
        onView(withId()).;
    }

    @Test
    public void startDeckEdit() {

    }
}
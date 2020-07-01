package com.example.evilcards.test;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import com.example.evilcards.R;
import com.example.evilcards.library.view.LibraryActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
public class LibraryActivityTest {

    @Rule
    public ActivityTestRule<LibraryActivity> activityTestRule =
            new ActivityTestRule<LibraryActivity>(LibraryActivity.class);

    @Test
    public void displayAddDeckButton() {
        onView(withId(R.id.adddeckbutton)).
                check(matches(isDisplayed()));
    }

    @Test
    public void clickAddDeckButton() {
        onView(withId(R.id.adddeckbutton))
                .perform(click());
        onView(withId(R.id.deck_edit_constraintlayout))
                .check(matches(isDisplayed()));
    }

    @Test
    public void displayRecyclerViewTest() {
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()));
    }

}
package com.example.evilcards.test;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import com.example.evilcards.R;
import com.example.evilcards.library.view.CardEditActivity;
import com.example.evilcards.library.view.LibraryActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4ClassRunner.class)
public class CardEditActivityTest {

    @Rule
    public ActivityTestRule<CardEditActivity> activityTestRule =
            new ActivityTestRule<CardEditActivity>(CardEditActivity.class);

    @Test
    public void editCardText() {
        onView(withId(R.id.editCardText)).perform(typeText("Frage"));
        onView(allOf(withId(R.id.editCardText), withText("Frage")));
    }

    @Test
    public void checkIsQuestion() {
        onView(withId(R.id.isquestioncheckbox))
                .perform(click());
        onView(withId(R.id.isquestioncheckbox))
                .check(matches(isChecked()));
    }

    @Test
    public void displayConfirmButton() {
        onView(withId(R.id.confirmbutton)).check(matches(isDisplayed()));
    }

    @Test
    public void clickConfirmButton(){
        onView(withId(R.id.confirmbutton)).perform(click());
        onView(withId(R.id.library_constraintlayout)).check(matches(isDisplayed()));
    }

}
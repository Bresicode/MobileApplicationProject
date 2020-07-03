package com.example.evilcards.test;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.example.evilcards.R;
import com.example.evilcards.library.control.LibraryAccessor;
import com.example.evilcards.library.control.LibraryAccessorImpl;
import com.example.evilcards.library.control.LibraryFileManagerImpl;
import com.example.evilcards.library.model.CardImpl;
import com.example.evilcards.library.view.LibraryActivity;
import com.example.evilcards.menu.view.MenuActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withResourceName;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.example.evilcards.test.MyViewMatcher.atPosition;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4ClassRunner.class)
public class IntegrationTest {

    Context mContext;
    File file;
    @Rule
    public ActivityTestRule<MenuActivity> activityTestRule =
            new ActivityTestRule<MenuActivity>(MenuActivity.class);

    @Test
    public void TestUserEditsCard() {
        Activity activity = activityTestRule.getActivity();
        LibraryAccessor la = new LibraryAccessorImpl(activity.getApplicationContext());
        la.getFm().writeToFile(new ArrayList<CardImpl>());
        onView(withId(R.id.libraryButton)).perform(click());
        onView(withId(R.id.library_constraintlayout)).check(matches(isDisplayed()));
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()));
        onView(withId(R.id.adddeckbutton)).perform(click());
        onView(withId(R.id.editCardText)).perform(typeText("Frage"));
        onView(withId(R.id.isquestioncheckbox)).perform(click());
        onView(withId(R.id.confirmbutton)).perform(click());
        onView(withId(R.id.adddeckbutton)).perform(click());
        onView(withId(R.id.editCardText)).perform(typeText("Antwort1"));
        onView(withId(R.id.confirmbutton)).perform(click());
        onView(withId(R.id.adddeckbutton)).perform(click());
        onView(withId(R.id.editCardText)).perform(typeText("Antwort2"));
        onView(withId(R.id.confirmbutton)).perform(click());
        onView(withId(R.id.recyclerView))
                .check(matches(atPosition(0, hasDescendant(withText("Frage")))));
        onView(withId(R.id.recyclerView))
                .check(matches(atPosition(1, hasDescendant(withText("Antwort1")))));
        onView(withId(R.id.recyclerView))
                .check(matches(atPosition(2, hasDescendant(withText("Antwort2")))));
    }

}
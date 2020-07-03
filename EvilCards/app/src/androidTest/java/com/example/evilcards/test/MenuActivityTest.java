package com.example.evilcards.test;

import android.content.ComponentName;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import com.example.evilcards.R;
import com.example.evilcards.game.view.GameActivity;
import com.example.evilcards.library.view.CardEditActivity;
import com.example.evilcards.library.view.LibraryActivity;
import com.example.evilcards.menu.view.MenuActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.InstrumentationRegistry.getTargetContext;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MenuActivityTest {

    @Rule
    public IntentsTestRule<MenuActivity> activityTestRule =
            new IntentsTestRule<MenuActivity>(MenuActivity.class);

    @Test
    public void displayPlayButton() {
        onView(withId(R.id.playButton)).
                check(matches(isDisplayed()));
    }

    @Test
    public void clickPlayButton() {
        onView(withId(R.id.playButton)).perform(click());
        intended(hasComponent(new ComponentName(getTargetContext(), GameActivity.class)));
    }

    @Test
    public void displaylibraryButton() {
        onView(withId(R.id.libraryButton)).check(matches(isDisplayed()));
    }

    @Test
    public void clicklibraryButton() {
        onView(withId(R.id.libraryButton)).perform(click());
        intended(hasComponent(new ComponentName(getTargetContext(), LibraryActivity.class)));
    }

}

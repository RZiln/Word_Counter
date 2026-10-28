package com.example.wordcounter;

import android.content.Context;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.core.StringContains;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void analyzeButtonDisplaysCorrect() {
        Espresso.onView(ViewMatchers.withId(R.id.InputText))
                .perform(ViewActions.typeText("Hello World 123"));

        Espresso.closeSoftKeyboard();

        Espresso.onView(ViewMatchers.withId(R.id.spinner))
                .perform(ViewActions.click());

        Espresso.onData(is("SENTENCES"))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.Button))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.results))
                .check(ViewAssertions.matches(
                        ViewMatchers.withText(containsString("SENTENCES 1"))
                ));
    }
}
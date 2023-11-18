package com.example.eudescarto;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import org.junit.Rule;
import org.junit.Test;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


public class BonusScreenTest {

    @Rule
    public ActivityScenarioRule<bonus_screen> activityScenarioRule =
            new ActivityScenarioRule<>(bonus_screen.class);


    @Test
    public void testButtonChevron() {

        onView(withId(R.id.imageViewChevron)).perform(scrollTo());

        onView(withId(R.id.imageViewChevron)).perform(click());

        onView(withId(R.id.ProfileLayout))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testScreenProfile() {

        onView(withId(R.id.imageView12)).perform(scrollTo());

        onView(withId(R.id.imageView12)).perform(click());

        onView(withId(R.id.ProfileLayout))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testScreenConfig() {

        onView(withId(R.id.imageView15)).perform(scrollTo());

        onView(withId(R.id.imageView15)).perform(click());

        onView(withId(R.id.ConfigScreen))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        onView(withId(R.id.imageViewChevron)).perform(click());

        onView(withId(R.id.BonusScreen))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

}

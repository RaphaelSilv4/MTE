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

public class ProfileTest {

    @Rule
    public ActivityScenarioRule<profile> activityScenarioRule =
            new ActivityScenarioRule<>(profile.class);

    @Test
    public void testScreenBonification() {

        onView(withId(R.id.imageViewInput1)).perform(scrollTo());

        onView(withId(R.id.imageViewInput1)).perform(click());

        onView(withId(R.id.BonusScreen))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testScreenRequestCollection() {

        onView(withId(R.id.imageViewInput2)).perform(scrollTo());

        onView(withId(R.id.imageViewInput2)).perform(click());

        onView(withId(R.id.CollectScreen))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testScreenConfig() {

        onView(withId(R.id.imageViewInputConfig)).perform(scrollTo());

        onView(withId(R.id.imageViewInputConfig)).perform(click());

        onView(withId(R.id.ConfigScreen))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        onView(withId(R.id.imageViewChevron)).perform(click());

        onView(withId(R.id.ProfileLayout))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

}

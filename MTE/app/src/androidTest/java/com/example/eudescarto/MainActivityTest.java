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
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;


public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testButtonLogin() {

        onView(withId(R.id.buttonLogin)).perform(scrollTo());

        onView(withId(R.id.buttonLogin)).perform(click());

        onView(withId(R.id.ProfileLayout))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));


    }

    @Test
    public void testLoginForm() {
        // Teste para o campo de nome de usuário
        String userNameText = "Texto de teste";

        Espresso.onView(ViewMatchers.withId(R.id.InputUserName))
                .perform(ViewActions.typeText(userNameText), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.InputUserName))
                .check(ViewAssertions.matches(ViewMatchers.withText(userNameText)));

        // Teste para o campo de senha
        String passwordText = "SenhaSecreta123";
        
        Espresso.onView(ViewMatchers.withId(R.id.textInputpassword))
                .perform(ViewActions.typeText(passwordText), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.textInputpassword))
                .check(ViewAssertions.matches(ViewMatchers.withText(passwordText)));
    }


}

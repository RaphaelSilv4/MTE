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

public class SignUpTest {

    @Rule
    public ActivityScenarioRule<sign_up> activityScenarioRule =
            new ActivityScenarioRule<>(sign_up.class);

    @Test
    public void testButtonLoginAccount() {
        // Role até o botão
        onView(withId(R.id.buttonLoginAccount)).perform(scrollTo());

        // Clique no botão
        onView(withId(R.id.buttonLoginAccount)).perform(click());

        // Verifique se a tela de login está visível
        onView(withId(R.id.LoginScreen))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testButtonNewAccount() {
        // repetindo o mesmo teste para o botão de criação da conta
        onView(withId(R.id.buttonNewAccount)).perform(scrollTo());

        onView(withId(R.id.buttonNewAccount)).perform(click());

        onView(withId(R.id.ProfileLayout))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testSignUpForm() {
        // Texto a ser inserido em cada TextInputEditText
        String nameText = "John Doe";
        String cpfText = "12345678901";
        String cepText = "12345-678";
        String emailText = "john.doe@example.com";
        String phoneText = "1234567890";
        String passwordText = "SecurePassword123";
        String password2Text = "SecurePassword123";

        // Teste para o campo de nome
        Espresso.onView(ViewMatchers.withId(R.id.textInputName))
                .perform(ViewActions.typeText(nameText), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.textInputName))
                .check(ViewAssertions.matches(ViewMatchers.withText(nameText)));

        // Teste para o campo de CPF
        Espresso.onView(ViewMatchers.withId(R.id.textInputcpf))
                .perform(ViewActions.typeText(cpfText), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.textInputcpf))
                .check(ViewAssertions.matches(ViewMatchers.withText(cpfText)));

        // Teste para o campo de CEP
        Espresso.onView(ViewMatchers.withId(R.id.textInputcep))
                .perform(ViewActions.typeText(cepText), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.textInputcep))
                .check(ViewAssertions.matches(ViewMatchers.withText(cepText)));

        // Teste para o campo de e-mail
        Espresso.onView(ViewMatchers.withId(R.id.textInputemail))
                .perform(ViewActions.typeText(emailText), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.textInputemail))
                .check(ViewAssertions.matches(ViewMatchers.withText(emailText)));

        // Teste para o campo de telefone
        Espresso.onView(ViewMatchers.withId(R.id.textInputPhone))
                .perform(ViewActions.typeText(phoneText), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.textInputPhone))
                .check(ViewAssertions.matches(ViewMatchers.withText(phoneText)));

        // Teste para o campo de senha
        Espresso.onView(ViewMatchers.withId(R.id.textInputPassword))
                .perform(ViewActions.typeText(passwordText), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.textInputPassword))
                .check(ViewAssertions.matches(ViewMatchers.withText(passwordText)));

        // Teste para o segundo campo de senha
        Espresso.onView(ViewMatchers.withId(R.id.textInputPassword2))
                .perform(ViewActions.typeText(password2Text), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.textInputPassword2))
                .check(ViewAssertions.matches(ViewMatchers.withText(password2Text)));
    }


}

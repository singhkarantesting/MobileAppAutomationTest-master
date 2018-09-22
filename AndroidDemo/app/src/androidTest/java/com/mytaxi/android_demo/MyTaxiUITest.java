package com.mytaxi.android_demo;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;
import com.mytaxi.android_demo.activities.MainActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MyTaxiUITest {

    private String username="crazydog335";
    private String password="venture";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test

    public void loginAndSearchDriver_test()  {

        onView(withId(R.id.edt_username)).perform(typeText(username));
        onView(withId(R.id.edt_password)).perform(typeText(password));
        onView(withId(R.id.btn_login)).perform(click());

        onView(withId(R.id.textSearch)).perform(typeText("sa"));
        onView(withText("Sarah Scott"))
                .inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .perform(click());

        onView(withId(R.id.fab)).perform(click());
    }
}

package com.kwin.android.traveller.activities;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.kwin.android.traveller.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by Novitee_Win Ko KO on 1/1/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityEspresso {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    @Test
    public void checkHomeScreen() {
        // check home screen is display
        onView(withId(R.id.tv_home)).check(matches(isDisplayed()));
    }

    @Test
    public void checkNearByScreen() {
        // check near by screen is display
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.action_near_by), isDisplayed()));
        bottomNavigationItemView.perform(click());

        onView(withId(R.id.tv_near_by)).check(matches(withText("Near by fragment")));

    }

    @Test
    public void checkFavoritesScreen() {
        // check the favorites screen is display
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.action_favorites), isDisplayed()));
        bottomNavigationItemView.perform(click());

        onView(withId(R.id.tv_favorites)).check(matches(withText("Favorites fragment")));
    }


    public static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}

package com.gayathriarumugam.stackapps.test

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.gayathriarumugam.stackapps.View.MainActivity
import com.gayathriarumugam.stackapps.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.*


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField
    var activityRule = ActivityTestRule<MainActivity>(
        MainActivity::class.java
    )

    @Test
    fun clickSearchButton_checksForEmptyString() {

        // passes if the textView does not match the empty string
        onView(withId(R.id.nameEditText)).perform(typeText(""))

        // perform a click on the button
        onView(withId(R.id.btnSearch)).perform(click())

    }
}
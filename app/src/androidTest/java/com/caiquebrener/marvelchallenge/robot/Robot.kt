package com.caiquebrener.marvelchallenge.robot

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matchers.not


open class Robot {

    fun isDisplayed(@IdRes viewId:Int){
        onView(withId(viewId)).check(matches(isDisplayed()))
    }

    fun isNotDisplayed(@IdRes viewId: Int){
        onView(withId(viewId)).check(matches(not(isDisplayed())))
    }


}
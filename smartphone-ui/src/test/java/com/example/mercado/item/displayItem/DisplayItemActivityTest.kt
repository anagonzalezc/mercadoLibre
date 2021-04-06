package com.example.mercado.item.displayItem

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mercado.OpenItemDatabaseApp
import com.example.mercado.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DisplayItemActivityTest {


    private val applicationContext = getApplicationContext<OpenItemDatabaseApp>()
    private lateinit var scenario: ActivityScenario<DisplayItemActivity>

    @Before
    fun setUp() {
        scenario = launch(DisplayItemActivity::class.java)
    }

    @Test
    fun whenActivityLaunch_thenShouldDisplaySearchImage() {
        onView(withId(R.id.aciv_search_display_item)).check(matches(isDisplayed()))
    }

    @Test
    fun whenActivityLaunch_thenShouldDisplaySearchText() {
        onView(withId(R.id.tv_instructions)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun whenActivityLunch_thenShouldShowMakeASearchText() {
        onView(withId(R.id.tv_instructions)).check(matches(withText(applicationContext.getString(R.string.make_a_search))))
    }

    @Test
    fun whenActivityLunch_menuSearchShouldBeVisible() {
        onView(withId(R.id.menu_search)).check(matches(isDisplayed()))
    }


    @Test
    fun whenRecreateActivity_thenShouldDisplaySearchImage() {

        scenario.recreate()

        onView(withId(R.id.aciv_search_display_item)).check(matches(isDisplayed()))
    }



}
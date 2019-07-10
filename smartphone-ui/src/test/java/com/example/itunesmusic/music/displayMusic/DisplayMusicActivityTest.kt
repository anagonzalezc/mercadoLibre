package com.example.itunesmusic.music.displayMusic

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.itunesmusic.OpenMusicDatabaseApp
import com.example.itunesmusic.R
import com.example.itunesmusic.music.factory.MoviesFactory
import com.example.itunesmusic.music.model.MusicView
import com.example.itunesmusic.test.RecyclerViewMatcher
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DisplayMusicActivityTest {


    private val applicationContext = getApplicationContext<OpenMusicDatabaseApp>()
    private lateinit var scenario: ActivityScenario<DisplayMusicActivity>

    @Before
    fun setUp() {
        scenario = launch(DisplayMusicActivity::class.java)
    }

    @Test
    fun whenActivityLaunch_thenShouldDisplaySearchImage() {
        onView(withId(R.id.aciv_search_display_music)).check(matches(isDisplayed()))
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

        onView(withId(R.id.aciv_search_display_music)).check(matches(isDisplayed()))
    }



}
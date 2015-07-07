package com.chefmodo;

import android.view.Menu;
import android.widget.ImageView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class HomeActivityTest {

    private HomeActivity homeActivity;

    @Before
    public void setUp() throws Exception {
        homeActivity = Robolectric.buildActivity(HomeActivity.class).create().visible().get();
    }

    @Test
    public void shouldHaveAllUIComponents(){
        ImageView screenTitle = (ImageView) homeActivity.findViewById(R.id.screen_title);

        assertThat(homeActivity.findViewById(R.id.search_bar), is(notNullValue()));
        assertThat(screenTitle.getBackground(), is(notNullValue()));
    }

    @Test
    public void shouldHaveSearchInTheActionBar(){
        Menu homeMenu = shadowOf(homeActivity).getOptionsMenu();

        assertThat(homeMenu.getItem(0).getTitle().toString(), is("SEARCH"));
    }
}

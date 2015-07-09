package com.chefmodo.homeActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import com.chefmodo.BuildConfig;
import com.chefmodo.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.fakes.RoboMenuItem;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class SearchFragmentTest {

    private HomeActivity homeActivity;

    @Before
    public void setUp() throws Exception {
        homeActivity = Robolectric.buildActivity(HomeActivity.class).create().visible().get();
    }

    @Test
    public void shouldStartActivityWithTheCorrectFragment(){
        ImageView screenTitle = (ImageView) homeActivity.findViewById(R.id.screen_title);

        assertThat(homeActivity.findViewById(R.id.search_ingredient_box), is(notNullValue()));
        assertThat(screenTitle.getBackground(), is(notNullValue()));
    }

    @Test
    public void shouldHaveSearchInTheActionBar(){
        Menu homeMenu = shadowOf(homeActivity).getOptionsMenu();

        MenuItem searchButton = homeMenu.getItem(0);
        assertThat(searchButton.getTitle().toString(), is("SEARCH"));
        assertThat(homeMenu.getItem(0).isEnabled(), is(false));
    }

    @Test
    public void shouldDisableSearchButtonWhenSearchFieldIsEmpty() throws Exception {
        ((EditText) homeActivity.findViewById(R.id.search_ingredient_box)).setText("");
        Menu homeMenu = shadowOf(homeActivity).getOptionsMenu();

        assertThat(homeMenu.getItem(0).isEnabled(), is(false));
    }

    @Test
    public void shouldEnableSearchButtonWhenSearchFieldIsNotEmpty() throws Exception {
        ((EditText) homeActivity.findViewById(R.id.search_ingredient_box)).setText("I am searching");
        Menu homeMenu = shadowOf(homeActivity).getOptionsMenu();

        assertThat(homeMenu.getItem(0).isEnabled(), is(true));
    }

    @Test
    public void shouldStartTheSearchResultsFragmentWhenClickingSearchButton() throws Exception {
        MenuItem searchButton = new RoboMenuItem() {
            public int getItemId() {
                return R.id.search_button;
            }

        };

        ((EditText) homeActivity.findViewById(R.id.search_ingredient_box)).setText("I am searching");

        homeActivity.onOptionsItemSelected(searchButton);

        assertThat(homeActivity.findViewById(R.id.search_ingredient_box), is(nullValue()));
    }
}

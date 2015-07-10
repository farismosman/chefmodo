package com.chefmodo.homeActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

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
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class SearchFragmentResultTest {

    private HomeActivity homeActivity;

    @Before
    public void setUp() throws Exception {
        homeActivity = Robolectric.buildActivity(HomeActivity.class).create().visible().get();
    }

    @Test
    public void shouldHaveTheSearchQueryFromPreviousScreen() throws Exception {
        MenuItem searchButton = new RoboMenuItem() {
            public int getItemId() {
                return R.id.search_button;
            }
        };

        ((EditText) homeActivity.findViewById(R.id.search_ingredient_box)).setText("recipe for dinner");
        homeActivity.onOptionsItemSelected(searchButton);

        SearchResultFragment fragment = (SearchResultFragment) homeActivity.getFragmentManager().findFragmentById(R.id.home_fragments_container);
        Bundle bundle = fragment.getArguments();

        assertThat(bundle.getString(HomeActivity.SEARCH_QUERY), is("recipe for dinner"));
    }
}

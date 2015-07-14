package com.chefmodo.homeActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import com.chefmodo.BuildConfig;
import com.chefmodo.R;
import com.chefmodo.endpoints.RecipeService;
import com.squareup.okhttp.internal.http.HttpConnection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.fakes.RoboMenuItem;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class SearchFragmentResultTest {

    private HomeActivity homeActivity;

    @Mock private RecipeService recipeService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        when(recipeService.find()).thenReturn(null);

        populateSearchFieldAndClickSearchButton();
    }

    @Test
    public void shouldHaveTheSearchQueryFromPreviousScreen() throws Exception {
        SearchResultFragment fragment = (SearchResultFragment) homeActivity.getFragmentManager().findFragmentById(R.id.home_fragments_container);
        Bundle searchQueryBundle = fragment.getArguments();

        assertThat(searchQueryBundle.getString(HomeActivity.SEARCH_QUERY), is("recipe for dinner"));
    }

    @Test
    public void shouldCallEndPoint() {
        verify(recipeService).find();
    }

    private void populateSearchFieldAndClickSearchButton() {
        homeActivity = Robolectric.buildActivity(HomeActivity.class).create().visible().get();
        MenuItem searchButton = new RoboMenuItem() {
            public int getItemId() {
                return R.id.search_button;
            }
        };

        ((EditText) homeActivity.findViewById(R.id.search_ingredient_box)).setText("recipe for dinner");
        homeActivity.setRecipeService(recipeService);
        homeActivity.onOptionsItemSelected(searchButton);
    }
}

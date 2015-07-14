package com.chefmodo.homeActivity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import com.chefmodo.R;
import com.chefmodo.endpoints.RecipeService;

import retrofit.RestAdapter;

public class HomeActivity extends Activity {

    private static String END_POINT = "http://localhost:8081";
    private FragmentManager fragmentManager = getFragmentManager();
    public static final String SEARCH_QUERY = "SearchQuery";
    private RecipeService recipeService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        SearchFragment searchFragment = new SearchFragment();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.home_fragments_container, searchFragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Bundle searchContentBundle = new Bundle();
        String searchQuery = ((EditText) findViewById(R.id.search_ingredient_box)).getText().toString();
        searchContentBundle.putString(SEARCH_QUERY, searchQuery);

        SearchResultFragment searchResultFragment = new SearchResultFragment();
        searchResultFragment.setArguments(searchContentBundle);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.home_fragments_container, searchResultFragment);
        fragmentTransaction.commit();

        return super.onOptionsItemSelected(item);
    }

    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    public RecipeService getRecipeService() {
        if (recipeService == null) {
            recipeService = new RestAdapter.Builder().
                    setLogLevel(RestAdapter.LogLevel.FULL)
                    .setEndpoint(END_POINT)
                    .build()
                    .create(RecipeService.class);
        }
        return recipeService;
    }
}

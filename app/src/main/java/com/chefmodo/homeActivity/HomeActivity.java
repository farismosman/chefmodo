package com.chefmodo.homeActivity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import com.chefmodo.R;

public class HomeActivity extends Activity {

    private FragmentManager fragmentManager = getFragmentManager();
    public static final String SEARCH_QUERY = "SearchQuery";

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
}

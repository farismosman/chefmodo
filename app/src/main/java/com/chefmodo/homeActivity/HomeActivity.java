package com.chefmodo.homeActivity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

import com.chefmodo.R;

public class HomeActivity extends Activity {

    private FragmentManager fragmentManager = getFragmentManager();

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
        SearchResultFragment searchResultFragment = new SearchResultFragment();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.home_fragments_container, searchResultFragment);
        fragmentTransaction.commit();

        return super.onOptionsItemSelected(item);
    }
}

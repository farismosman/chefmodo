package com.chefmodo;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class HomeActivity extends Activity {

    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        EditText searchField = (EditText) findViewById(R.id.search_bar);

        searchField.addTextChangedListener(toggleSearchButton());
    }

    private TextWatcher toggleSearchButton() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                MenuItem searchButton = menu.getItem(0);

                if (charSequence.length() > 0) {
                    searchButton.setEnabled(true);
                } else {
                    searchButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);

        menu.getItem(0).setEnabled(false);

        this.menu = menu;
        return super.onCreateOptionsMenu(menu);
    }
}

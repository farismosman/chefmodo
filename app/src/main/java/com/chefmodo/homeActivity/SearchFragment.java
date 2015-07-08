package com.chefmodo.homeActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.chefmodo.R;

public class SearchFragment extends Fragment {
    private Menu menu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);
        setHasOptionsMenu(true);

        EditText searchField = (EditText) view.findViewById(R.id.search_bar);
        searchField.addTextChangedListener(toggleSearchButton());

        return view;
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.home_menu, menu);

        menu.getItem(0).setEnabled(false);

        this.menu = menu;

        super.onCreateOptionsMenu(menu, inflater);
    }
}

package com.chefmodo;

import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class HomeActivityTest {
    @Test
    public void shouldHaveAllUIComponents(){
        HomeActivity homeActivity = Robolectric.buildActivity(HomeActivity.class).create().get();
        TextView screenTitle = (TextView) homeActivity.findViewById(R.id.screen_title);

        assertThat(homeActivity.findViewById(R.id.search_bar), is(notNullValue()));
        assertThat(screenTitle.getText().toString(), is("Chefmodo"));
    }
}

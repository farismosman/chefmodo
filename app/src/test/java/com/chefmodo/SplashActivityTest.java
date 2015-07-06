package com.chefmodo;

import android.content.Intent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class SplashActivityTest {

    @Test
    public void shouldStartTheHomeActivityAfterTwoSeconds() {
        SplashActivity splashActivity = Robolectric.buildActivity(SplashActivity.class).create().get();

        Intent intent = new Intent(splashActivity.getApplicationContext(), HomeActivity.class);
        Intent nextStartedActivity = shadowOf(splashActivity).getNextStartedActivity();

        assertThat(nextStartedActivity, is(intent));
    }
}
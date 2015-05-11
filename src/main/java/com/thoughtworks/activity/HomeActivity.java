package com.thoughtworks.activity;

import android.app.Activity;
import android.os.Bundle;
import com.thoughtworks.R;

public class HomeActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.home);
  }
}

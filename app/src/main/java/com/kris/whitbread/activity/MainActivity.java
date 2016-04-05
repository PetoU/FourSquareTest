package com.kris.whitbread.activity;

import android.os.Bundle;

import com.kris.whitbread.R;
import com.kris.whitbread.fragment.VenueFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        if (savedInstanceState == null) {
            inflateFragment(R.id.frame, VenueFragment.newInstance(), VenueFragment.class.getName());
        }
    }
}

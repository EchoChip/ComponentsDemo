package com.echochip.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    MainActivity activity = this;
    private static final String TAG = "MainActivity";

    TabLayout tabLayout;
    ViewPager viewPager;
    private String[] tabTitles = new String[]{"tab1", "tab2", "tab3"};
    private Fragment[] mFragments;

    ContentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        mFragments = new Fragment[tabTitles.length];

        for (int i = 0; i < tabTitles.length; i++) {
            ContentFragment pageFragment = new ContentFragment();
            Bundle args = new Bundle();
            args.putString(ContentFragment.tag, tabTitles[i]);
            pageFragment.setArguments(args);

            mFragments[i] = pageFragment;
        }

        adapter = new ContentAdapter(getSupportFragmentManager(),tabTitles, mFragments);

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

}

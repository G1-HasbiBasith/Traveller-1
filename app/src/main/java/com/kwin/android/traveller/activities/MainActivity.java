package com.kwin.android.traveller.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.kwin.android.traveller.R;
import com.kwin.android.traveller.adapters.MainPagerAdapter;
import com.kwin.android.traveller.fragments.FavoritesFragment;
import com.kwin.android.traveller.fragments.HomeFragment;
import com.kwin.android.traveller.fragments.NearByFragment;
import com.roughike.bottombar.BottomBarTab;

public class MainActivity extends AppCompatActivity {

    BottomBarTab nearby;
    ViewPager pager;
    BottomNavigationView bottomNavigationView;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);


        pager = (ViewPager) findViewById(R.id.contentContainer);
        setupViewPager(pager);


        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }

                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_favorites:
                                pager.setCurrentItem(0);
                                break;
                            case R.id.action_home:
                                pager.setCurrentItem(1);
                                break;
                            case R.id.action_near_by:
                                pager.setCurrentItem(2);
                                break;
                        }
                        return false;
                    }
                });
        pager.setCurrentItem(1);
    }

    private void setupViewPager(ViewPager viewPager) {
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());
        HomeFragment homeFragment = new HomeFragment();
        NearByFragment nearByFragment = new NearByFragment();
        FavoritesFragment favoritesFragment = new FavoritesFragment();

        adapter.addFragment(favoritesFragment);
        adapter.addFragment(homeFragment);
        adapter.addFragment(nearByFragment);

        viewPager.setAdapter(adapter);


    }


}

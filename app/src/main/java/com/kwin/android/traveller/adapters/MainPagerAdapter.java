package com.kwin.android.traveller.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Novitee_Win Ko KO on 12/30/2016.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();


    public List<Fragment> getFragmentList() {
        return fragmentList;
    }

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragment(Fragment fragment) {
        fragmentList.add(fragment);
    }
}

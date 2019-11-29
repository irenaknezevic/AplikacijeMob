package com.example.mojaaplikacija;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return new PersonalInfoFragment();
        }
        if(position == 1) {
            return new StudentInfoFragment();
        }
        if(position == 2) {
            return new SummaryFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

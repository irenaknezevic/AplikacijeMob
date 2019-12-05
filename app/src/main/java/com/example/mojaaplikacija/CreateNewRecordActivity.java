package com.example.mojaaplikacija;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class CreateNewRecordActivity extends AppCompatActivity implements PersonalInfoFragment.PersonalInfoListener, StudentInfoFragment.StudentInfoListener{
    public static ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_record);

        viewPager = findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    @Override
    public void onPersonalInfoSent(String ime, String prezime, String datum) {
        String tag = "android:switcher:" + R.id.viewpager + ":" + 2;
        SummaryFragment summaryFragment = (SummaryFragment) getSupportFragmentManager().findFragmentByTag(tag);
        summaryFragment.updatePersonalInfo(ime, prezime, datum);
    }

    @Override
    public void onStudentInfoSent(String predmet, String imeProf, String akGod, String satiPred, String satiLV) {
        String tag = "android:switcher:" + R.id.viewpager + ":" + 2;
        SummaryFragment summaryFragment = (SummaryFragment) getSupportFragmentManager().findFragmentByTag(tag);
        summaryFragment.updateStudentInfo(predmet, imeProf, akGod, satiPred, satiLV);
    }

    /*public static void setCurrentItem(int item, boolean smoothScroll) {
        viewPager.setCurrentItem(item, smoothScroll);
    }*/
}

package com.anatraj.philarttools.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;

import com.anatraj.philarttools.R;
import com.anatraj.philarttools.fragments.TabbedFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements TabbedFragment.PagingHost {

    @BindView(R.id.vp_mainPager)
    ViewPager mainPager;

    @BindView(R.id.btn_pageOne)
    Button pageOneButton;

    @BindView(R.id.btn_pageTwo)
    Button pageTwoButton;

    @BindView(R.id.btn_pageThree)
    Button pageThreeButton;


    private class MainTabAdapter extends FragmentStatePagerAdapter {

        private SparseArray<Fragment> mFragments;

        MainTabAdapter(FragmentManager fm) {
            super(fm);
            mFragments = new SparseArray<>();
        }

        @Override
        public Fragment getItem(int position) {

            Fragment t = mFragments.get(position);
            if (t == null) {
                t = new TabbedFragment();
                mFragments.put(position, t);
            }

            return t;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        // set up the pager for the fragments
        mainPager.setAdapter(new MainTabAdapter(getSupportFragmentManager()));

        pageOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPage(1);
            }
        });

        pageTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPage(2);
            }
        });

        pageThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPage(3);
            }
        });
    }

    @Override
    public void goToPage(int page) {
        int actualPage = (page - 1);
        mainPager.setCurrentItem(actualPage);
    }
}

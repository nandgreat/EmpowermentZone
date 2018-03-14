package com.altitude.nandom.empowermentzone.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.altitude.nandom.empowermentzone.R;
import com.altitude.nandom.empowermentzone.profile_fragment.AdditionalDetails;
import com.altitude.nandom.empowermentzone.profile_fragment.BasicInfo;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileFragment extends Fragment {

    @BindView(R.id.materialViewPager)
    MaterialViewPager mViewPager;

    public static ProfileFragment newInstance() {
        // Required empty public constructor
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        // Inflate the layout for this fragment

        ButterKnife.bind(this, view);

//        final Toolbar toolbar = mViewPager.getToolbar();

        mViewPager = (MaterialViewPager) view.findViewById(R.id.materialViewPager);

        Toast.makeText(getContext(), "This is strange", Toast.LENGTH_SHORT).show();

//        if(toolbar != null){
//
//        }
//
//        toolbar.setTitleTextColor(Color.WHITE);

        mViewPager.getPagerTitleStrip().setAllCaps(false);
        mViewPager.getPagerTitleStrip().setTextColor(Color.WHITE);

        mViewPager.getViewPager().setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position % 4){
                    case 0:
                        return BasicInfo.newInstance();
                    case 1:
                        return AdditionalDetails.newInstance();
                    case 2:
                        return BasicInfo.newInstance();
                    case 3:
                        return BasicInfo.newInstance();
                    default:
                        return BasicInfo.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4){
                    case 0:
                        return "Basic Info";
                    case 1:
                        return "Additional Details";
                    case 2:
                        return "Work Experience";
                    case 3:
                        return "Certifications";
                }
                return "";
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());


        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.colorPrimary,
                                "http://phandroid.s3.amazonaws.com/wp-content/uploads/2014/06/android_google_moutain_google_now_1920x1080_wallpaper_Wallpaper-HD_2560x1600_www.paperhi.com_-640x400.jpg");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.colorPrimary,
                                "http://phandroid.s3.amazonaws.com/wp-content/uploads/2014/06/android_google_moutain_google_now_1920x1080_wallpaper_Wallpaper-HD_2560x1600_www.paperhi.com_-640x400.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.colorPrimary,
                                "http://phandroid.s3.amazonaws.com/wp-content/uploads/2014/06/android_google_moutain_google_now_1920x1080_wallpaper_Wallpaper-HD_2560x1600_www.paperhi.com_-640x400.jpg");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.colorPrimary,
                                "http://phandroid.s3.amazonaws.com/wp-content/uploads/2014/06/android_google_moutain_google_now_1920x1080_wallpaper_Wallpaper-HD_2560x1600_www.paperhi.com_-640x400.jpg");                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });



        final View logo = (View)view.findViewById(R.id.logo_white);
        if (logo != null) {
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getContext(), "Yes, the title is clickable", Toast.LENGTH_SHORT).show();
                }
            });
        }

        return view;

    }
}

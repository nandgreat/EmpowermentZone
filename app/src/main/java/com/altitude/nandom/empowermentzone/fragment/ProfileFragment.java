package com.altitude.nandom.empowermentzone.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.altitude.nandom.empowermentzone.R;
import com.altitude.nandom.empowermentzone.profile_fragment.AdditionalDetails;
import com.altitude.nandom.empowermentzone.profile_fragment.BasicInfo;
import com.altitude.nandom.empowermentzone.profile_fragment.Certifications;
import com.altitude.nandom.empowermentzone.profile_fragment.Education;
import com.altitude.nandom.empowermentzone.profile_fragment.RefereeFragment;
import com.altitude.nandom.empowermentzone.profile_fragment.WorkExperience;
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

        mViewPager = (MaterialViewPager) view.findViewById(R.id.materialViewPager);

        mViewPager.getPagerTitleStrip().setAllCaps(false);
        mViewPager.getPagerTitleStrip().setTextColor(Color.WHITE);

        mViewPager.getViewPager().setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position % 6) {
                    case 0:
                        return BasicInfo.newInstance();
                    case 1:
                        return AdditionalDetails.newInstance();
                    case 2:
                        return Education.newInstance();
                    case 3:
                        return WorkExperience.newInstance();
                    case 4:
                        return Certifications.newInstance();
                    case 5:
                        return RefereeFragment.newInstance();
                    default:
                        return Certifications.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 6;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 6) {
                    case 0:
                        return "Basic Info";
                    case 1:
                        return "Additional Details";
                    case 2:
                        return "Education";
                    case 3:
                        return "Work Experience";
                    case 4:
                        return "Certifications";
                    case 5:
                        return "Referee";
                }
                return "";
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());


        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorAndDrawable(R.color.colorPrimary,
                                getResources().getDrawable(R.drawable.bg_profile));
                    case 1:
                        return HeaderDesign.fromColorAndDrawable(R.color.colorPrimary,
                                getResources().getDrawable(R.drawable.bg_profile));
                    case 2:
                        return HeaderDesign.fromColorAndDrawable(R.color.colorPrimary,
                                getResources().getDrawable(R.drawable.bg_profile));
                    case 3:
                        return HeaderDesign.fromColorAndDrawable(R.color.colorPrimary,
                                getResources().getDrawable(R.drawable.bg_profile));
                    case 4:
                        return HeaderDesign.fromColorAndDrawable(R.color.colorPrimary,
                                getResources().getDrawable(R.drawable.bg_profile));
                    case 5:
                        return HeaderDesign.fromColorAndDrawable(R.color.colorPrimary,
                                getResources().getDrawable(R.drawable.bg_profile));
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        final View logo = (View) view.findViewById(R.id.logo_white);
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

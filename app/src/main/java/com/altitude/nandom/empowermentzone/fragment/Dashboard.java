package com.altitude.nandom.empowermentzone.fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.altitude.nandom.empowermentzone.R;

import az.plainpie.PieView;
import az.plainpie.animation.PieAngleAnimation;


public class Dashboard extends Fragment {

    Context context = getContext();

    Typeface typeface;


    public static Dashboard newInstance() {
        // Required empty public constructor
        Dashboard fragment = new Dashboard();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        PieView pieView = (PieView) view.findViewById(R.id.pieView);
        PieAngleAnimation animation = new PieAngleAnimation(pieView);
        animation.setDuration(3000);
        pieView.setPercentageBackgroundColor(getResources().getColor(R.color.colorAccent));
        pieView.startAnimation(animation);
        // Inflate the layout for this fragment
        return view;
    }

}

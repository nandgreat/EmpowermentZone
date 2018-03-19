package com.altitude.nandom.empowermentzone.profile_fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.altitude.nandom.empowermentzone.MonthYearPicker;

import com.altitude.nandom.empowermentzone.R;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;



import java.time.YearMonth;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class WorkExperience extends Fragment {

    @BindView(R.id.scrollView)
    NestedScrollView mScrollView;

    private EditText etWorkFrom, etWorkTo;
    private FloatingActionButton fabAdd;
    private Dialog addWorkDialog;
    private TextView textView1;
    private MonthYearPicker myp, myp2;


    public static WorkExperience newInstance() {
        return new WorkExperience();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_work_experience, container, false);

        myp = new MonthYearPicker(getActivity());
        myp2 = new MonthYearPicker(getActivity());
        myp.build(new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String monthYear = myp.getSelectedMonthName() + " " + myp.getSelectedYear();
                etWorkFrom.setText(monthYear);
            }
        }, null);

        myp2.build(new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String monthYear = myp2.getSelectedMonthName() + " " + myp2.getSelectedYear();
               etWorkTo.setText(monthYear);
            }
        }, null);

        fabAdd = (FloatingActionButton) view.findViewById(R.id.fabAddWork);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                textView1 = (TextView) view.findViewById(R.id.textView1);
                addWorkExperience();
            }


        });


        return view;
    }

    public void show(View view) {
        myp.show();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        MaterialViewPagerHelper.registerScrollView(getActivity(), mScrollView);
    }

    private void addWorkExperience() {
        addWorkDialog = new Dialog(getContext());
        addWorkDialog.setTitle("Add Work Experience");
        addWorkDialog.setContentView(R.layout.add_work_experience);
        addWorkDialog.setCanceledOnTouchOutside(true);
        addWorkDialog.show();

        etWorkFrom = (EditText) addWorkDialog.findViewById(R.id.etWorkFrom);
        etWorkTo = (EditText) addWorkDialog.findViewById(R.id.etWorkTo);

        etWorkFrom.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                show(view);
            }
        });
        etWorkTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show2(view);
            }
        });
    }

    private void show2(View view) {
        myp2.show();
    }
}

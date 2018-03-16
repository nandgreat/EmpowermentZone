package com.altitude.nandom.empowermentzone.profile_fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.altitude.nandom.empowermentzone.R;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdditionalDetails extends Fragment implements DatePickerDialog.OnDateSetListener{

    @BindView(R.id.scrollView)
    NestedScrollView mScrollView;


    Button button;
    private EditText etGender, etState, etDOB;
    AlertDialog alertDialog1;
    AlertDialog alertDialog2;

    DatePickerDialog dpd;
    CharSequence[] values = {" Male "," Female "};

    FragmentManager fm;

    CharSequence[] states = {
            "Abia",
            "Adamawa",
            "Anambra",
            "Akwa Ibom",
            "Bauchi",
            "Bayelsa",
            "Benue",
            "Borno",
            "Cross River",
            "Delta",
            "Ebonyi",
            "Enugu",
            "Edo",
            "Ekiti",
            "Gombe",
            "Imo",
            "Jigawa",
            "Kaduna",
            "Kano",
            "Katsina",
            "Kebbi",
            "Kogi",
            "Kwara",
            "Lagos",
            "Nasarawa",
            "Niger",
            "Ogun",
            "Ondo",
            "Osun",
            "Oyo",
            "Plateau",
            "Rivers",
            "Sokoto",
            "Taraba",
            "Yobe",
            "Zamfara"
    };

    public static AdditionalDetails newInstance() {
        return new AdditionalDetails();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_additional_details, container, false);


        Calendar now = Calendar.getInstance();
        dpd = DatePickerDialog.newInstance(
                (AdditionalDetails.this),
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );


        etGender = (EditText) view.findViewById(R.id.etGender);
        etState = (EditText) view.findViewById(R.id.etState);
        etDOB = (EditText) view.findViewById(R.id.etDOB);


        etGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAlertDialogWithRadioButtonGroup();
            }
        });


        etState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowAllStates();
            }
        });
        etDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dpd.show(getActivity().getFragmentManager(), "Datepickerdialog");

            }
        });

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        MaterialViewPagerHelper.registerScrollView(getActivity(), mScrollView);
    }

    public void CreateAlertDialogWithRadioButtonGroup(){


        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Select Gender");

        builder.setSingleChoiceItems(values, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                etGender.setText(values[item]);
                alertDialog1.dismiss();
            }
        });
        alertDialog1 = builder.create();
        alertDialog1.show();

    }

    public void ShowAllStates(){


        AlertDialog.Builder builder2 = new AlertDialog.Builder(getContext());

        builder2.setTitle("Select State");

        builder2.setSingleChoiceItems(states, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {

                etState.setText(states[item]);
                alertDialog2.dismiss();
            }
        });
        alertDialog2 = builder2.create();
        alertDialog2.show();

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = dayOfMonth + "/" + monthOfYear + "/" + year;

        etDOB.setText(date);
    }
}

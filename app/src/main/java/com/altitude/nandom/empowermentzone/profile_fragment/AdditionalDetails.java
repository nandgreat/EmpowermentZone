package com.altitude.nandom.empowermentzone.profile_fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.altitude.nandom.empowermentzone.R;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdditionalDetails extends Fragment {

    @BindView(R.id.scrollView)
    NestedScrollView mScrollView;


    Button button;
    private EditText etGender, etState;
    AlertDialog alertDialog1;
    AlertDialog alertDialog2;
    CharSequence[] values = {" Male "," Female "};

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_additional_details, container, false);
        // Inflate the layout for this fragment

        etGender = (EditText) view.findViewById(R.id.etGender);
        etState = (EditText) view.findViewById(R.id.etState);

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


}

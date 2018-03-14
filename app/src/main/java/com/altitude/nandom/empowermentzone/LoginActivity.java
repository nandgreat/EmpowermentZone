package com.altitude.nandom.empowermentzone;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etPhoneNumber, etLoginPassword;
    private TextInputLayout passwordLayout;
    private TextInputEditText etPassword;
    private TextView tvSignup;
    private Button bLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        passwordLayout = (TextInputLayout) findViewById(R.id.etLoginPassword);
        etPhoneNumber = (EditText) findViewById(R.id.etPhone);
        etLoginPassword = (TextInputEditText) findViewById(R.id.tietPassword);
        bLogin = (Button) findViewById(R.id.bLogin);

        etPhoneNumber.setText("08034444444");
        etLoginPassword.setText("pass");

        tvSignup = (TextView) findViewById(R.id.tvSignup);

        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupIntent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(signupIntent);

            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = etPhoneNumber.getText().toString();
                String password = etLoginPassword.getText().toString();

                if (!phone.isEmpty() && !password.isEmpty()) {

                    if (phone.contentEquals("08034444444") && password.contentEquals("pass")) {
                        Intent dashboardIntent = new Intent(LoginActivity.this, SampleActivity.class);
                        dashboardIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(dashboardIntent);
                    }else
                        Toast.makeText(LoginActivity.this, "Invalid Phone number and/or password", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(LoginActivity.this, "Please enter your Phone number and/or Password", Toast.LENGTH_SHORT).show();
            }
        });


    }
}

package com.example.greenflag;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    EditText email, password, password_re;
    Button next;
    ImageView emailCheck, emailCheck2, back, passWord1, passWord2;
    public static int NEW_TASK_REQUEST_CODE = 1810;
    boolean e = false, p = false, p_re = false;
    String pass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        email = findViewById(R.id.et_signup_email);
        password = findViewById(R.id.et_signup_password);
        password_re = findViewById(R.id.et_signup_password_retype);
        next = findViewById(R.id.btn_create_acc_next);
        back = findViewById(R.id.img_btn_back);

        final Context context = getApplicationContext();
        final CharSequence text = "Invalid Input";
        final int duration = Toast.LENGTH_SHORT;
        final Toast toast = Toast.makeText(context, text, duration);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPrevActivity();
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                emailCheck = findViewById(R.id.iv_signup_tick1);
                emailCheck2 = findViewById(R.id.iv_signup_cross1);
                if (isValid(s.toString())){
                    emailCheck.setVisibility(View.VISIBLE);
                    emailCheck2.setVisibility(View.INVISIBLE);
                    e = true;
                }
                else {
                    emailCheck.setVisibility(View.INVISIBLE);
                    emailCheck2.setVisibility(View.VISIBLE);
                    e = false;
                }
            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                 passWord1 = findViewById(R.id.iv_signup_tick2);
                passWord2 = findViewById(R.id.iv_signup_cross2);
                if (s.toString().length() >= 8){
                    passWord1.setVisibility(View.VISIBLE);
                    passWord2.setVisibility(View.INVISIBLE);
                    p = true;
                    pass = s.toString();
                }
                else {
                    passWord1.setVisibility(View.INVISIBLE);
                    passWord2.setVisibility(View.VISIBLE);
                    p = false;
                }
            }
        });

        password_re.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                passWord1 = findViewById(R.id.iv_signup_tick3);
                passWord2 = findViewById(R.id.iv_signup_cross3);
                if (s.toString().equals(pass)){
                    passWord1.setVisibility(View.VISIBLE);
                    passWord2.setVisibility(View.INVISIBLE);
                    p_re = true;
                }
                else {
                    passWord1.setVisibility(View.INVISIBLE);
                    passWord2.setVisibility(View.VISIBLE);
                    p_re = false;
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e == true && p == true && p_re == true)
                openNextActivity();
                else
                    toast.show();
            }
        });
    }

    private void openPrevActivity() {
        Intent openPreActivity = new Intent();
        openPreActivity.setClass(this, MainActivity.class);
        startActivityForResult(openPreActivity, NEW_TASK_REQUEST_CODE);
    }

    private void openNextActivity(){
        Intent openNextActivity = new Intent();
        openNextActivity.setClass(this, SetUpAcc.class);
        startActivityForResult(openNextActivity, NEW_TASK_REQUEST_CODE);
    }

    static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

}

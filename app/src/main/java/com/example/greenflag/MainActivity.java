package com.example.greenflag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button createAcc;
    public static int NEW_TASK_REQUEST_CODE = 1810; //random

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createAcc = findViewById(R.id.btn_create_acc);
        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }

    private void openNewActivity() {
        Intent openNewActivity = new Intent();
        openNewActivity.setClass(this, SignUp.class);
        startActivityForResult(openNewActivity, NEW_TASK_REQUEST_CODE);
    }
}



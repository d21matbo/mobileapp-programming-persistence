package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView displayView;
    private Button buttonRead;
    private Button buttonWrite;
    private EditText input1;
    private EditText input2;
    private EditText input3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
    }

    private void findViews() {
        displayView = findViewById(R.id.display_sqldata);
        buttonRead = findViewById(R.id.button_read);
        buttonWrite = findViewById(R.id.button_write);
        input1 = findViewById(R.id.input_1);
        input2 = findViewById(R.id.input_2);
        input3 = findViewById(R.id.input_3);
    }
}

package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView displayView;
    private Button buttonRead;
    private Button buttonWrite;
    private EditText inputLicNo;
    private EditText inputBrand;
    private EditText inputModel;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        databaseHelper = new DatabaseHelper(this);
    }

    private void findViews() {
        displayView = findViewById(R.id.display_sqldata);
        buttonRead = findViewById(R.id.button_read);
        buttonWrite = findViewById(R.id.button_write);
        inputLicNo = findViewById(R.id.input_licno);
        inputBrand = findViewById(R.id.input_brand);
        inputModel = findViewById(R.id.input_model);
    }

    private void insertSQLData() {
        ContentValues values = new ContentValues();
        values.put(DatabaseTables.Car.COLUMN_LICNO, inputLicNo.getText().toString());
        values.put(DatabaseTables.Car.COLUMN_BRAND, inputBrand.getText().toString());
        values.put(DatabaseTables.Car.COLUMN_MODEL, inputModel.getText().toString());
        databaseHelper.getWritableDatabase().insert(DatabaseTables.Car.TABLE_NAME, null, values);
    }
}

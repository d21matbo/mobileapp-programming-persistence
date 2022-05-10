package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
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

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view == buttonRead) {
                readSQLData();
            }
            else if (view == buttonWrite) {
                insertSQLData();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        databaseHelper = new DatabaseHelper(this);
        buttonWrite.setOnClickListener(onClickListener);
        buttonRead.setOnClickListener(onClickListener);
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

    private void readSQLData() {
        Cursor cursor = databaseHelper.getReadableDatabase().rawQuery(
                "SELECT * FROM " + DatabaseTables.Car.TABLE_NAME,
                null,
                null);
        String displayText = "";
        while(cursor.moveToNext()) {
            displayText = displayText + String.format("%s : %s %s\n",
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.Car.COLUMN_LICNO)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.Car.COLUMN_BRAND)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.Car.COLUMN_MODEL)));
        }
        displayView.setText(displayText);
    }
}

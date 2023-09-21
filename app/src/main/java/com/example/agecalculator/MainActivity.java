package com.example.agecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private EditText birthdateEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        birthdateEditText = findViewById(R.id.birthdateEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAge();
            }
        });
    }

    private void calculateAge() {
        String birthdateStr = birthdateEditText.getText().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        try {
            Date birthdate = sdf.parse(birthdateStr);
            Date currentDate = new Date();

            long diffInMillis = currentDate.getTime() - birthdate.getTime();
            long years = TimeUnit.MILLISECONDS.toDays(diffInMillis) / 365;

            resultTextView.setText("Your age is " + years + " years.");
        } catch (ParseException e) {
            e.printStackTrace();
            resultTextView.setText("Invalid date format. Please use MM/DD/YYYY.");
        }
    }
}

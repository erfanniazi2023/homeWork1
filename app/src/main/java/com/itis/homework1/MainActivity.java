package com.itis.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText heightEditText;
    private EditText weightEditText;
    private EditText ageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        heightEditText = findViewById(R.id.heightEditText);
        weightEditText = findViewById(R.id.weightEditText);
        ageEditText = findViewById(R.id.ageEditText);

        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                int height = Integer.parseInt(heightEditText.getText().toString());
                double weight = Double.parseDouble(weightEditText.getText().toString());
                int age = Integer.parseInt(ageEditText.getText().toString());

                if (name.isEmpty() || name.length() > 50) {
                    nameEditText.setError("Name cannot be empty or more than 50 character");
                    return;
                }

                if (height <= 0 || height >= 250) {
                    heightEditText.setError("Height must be greater than 0 and less than 250");
                    return;
                }

                if (weight <= 0 || weight >= 250) {
                    weightEditText.setError("Weight must be greater than 0 and less than 250");
                    return;
                }

                if (age <= 0 || age >= 150) {
                    ageEditText.setError("Age must be greater than 0 and less than 150");
                }


                double calories = calculateCalories(weight, height, age);
                TextView resultTextView = findViewById(R.id.resultTextView);
                resultTextView.setText("Your calorie is: "+ String.valueOf(calories));
            }

            private double calculateCalories(double weight, int height, int age) {
                double calories = weight * height * age;
                return calories;
            }
        });
    }
}